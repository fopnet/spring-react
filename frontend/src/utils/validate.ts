import { ChangeEvent, FormEvent, useState } from "react";

export interface Validation {
    required?: {
        value: boolean;
        message: string;
    };
    pattern?: {
        value: string | RegExp;
        message: string;
    };
    custom?: {
        isValid: (value: string) => boolean;
        message: string;
    };
}


// https://stackoverflow.com/questions/46155/whats-the-best-way-to-validate-an-email-address-in-javascript
export function validateEmail(email: any) {
    return String(email)
        .toLowerCase()
        .match(
            /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        );
}

type Validations<T extends {}> = Partial<Record<keyof T, Validation>>;
type ErrorRecord<T> = Partial<Record<keyof T, string>> | null;

export const useForm = <T extends Record<keyof T, any> = {}>(options?: {
    // We will soon see how to create this interface
    validations?: Validations<T>;
    // Allows a subset of T
    initialValues?: Partial<T>;
    onSubmit?: (e: FormEvent<HTMLFormElement>) => void;
}) => {
    const [data, setData] = useState<T>((options?.initialValues || {}) as T);
    const [errors, setErrors] = useState<ErrorRecord<T>>({});

    const handleValidateForm = (dataChanged: { [key: string]: any }): void => {
        const validations = options?.validations;
        if (validations) {
            let valid = true;
            const newErrors = {} as any;
            for (const key in validations) {
                // Object.keys(validations).forEach(key => {
                const value = dataChanged[key];
                const validation = validations[key];
                if (validation?.required?.value && !value) {
                    valid = false;
                    newErrors[key] = validation?.required?.message;
                }

                const pattern = validation?.pattern;
                if (pattern?.value && !RegExp(pattern.value).test(value)) {
                    valid = false;
                    newErrors[key] = pattern.message;
                }

                const custom = validation?.custom;
                if (custom?.isValid && !custom.isValid(value)) {
                    valid = false;
                    newErrors[key] = custom.message;
                }
            }

            if (!valid) {
                setErrors(newErrors);
                return newErrors;
            }
        }

        setErrors(null);
    };

    // Needs to extend unknown so we can add a generic to an arrow function
    const handleChange = <S extends unknown>(
        key: keyof T,
        sanitizeFn?: (value: string) => S
    ) => (e: ChangeEvent<HTMLInputElement & HTMLSelectElement>) => {
        const value = sanitizeFn ? sanitizeFn(e.target.value) : e.target.value;
        const newData = {
            ...data,
            [key]: value,
        };
        setData(newData);

        handleValidateForm(newData);
    };

    return {
        data,
        handleChange,
        handleValidateForm,
        errors,
    };
};
