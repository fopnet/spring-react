
import axios, { AxiosRequestConfig } from "axios";
import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Movie, RegistrationScore } from "types/Movie";
import { BASE_URL } from "utils/requests";
import { useForm } from "utils/validate";
import "./styles.css";


type Props = {
    movieId: string;
}


function FormCard({ movieId }: Props) {

    const [movie, setMovie] = useState<Movie>();
    const navigate = useNavigate();

    useEffect(() => {
        axios.get(`${BASE_URL}/movies/${movieId}`).then(resp => setMovie(resp.data));
    }, [movieId]);


    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const target: any = (event.target as any);
        const formData = {
            movieId: movieId,
            email: target.email.value,
            score: target.score.value
        }

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            method: 'PUT',
            url: '/scores',
            data: formData
        }

        axios(config).then(resp => navigate("/"));
    }


    const { handleChange, errors } = useForm<RegistrationScore>({
        validations: {
            email: {
                pattern: {
                    value: /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1, 3}\.[0-9]{1, 3}\.[0-9]{1, 3}\.[0-9]{1, 3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
                    message:
                        "Email inválido.",
                },
            },
            score: {
                custom: {
                    isValid: (value) => parseInt(value, 10) > 0,
                    message: 'Favor escolher uma avaliação para o filme.',
                },
            }
        },
        onSubmit: e => handleSubmit(e),
    });


    return (
        <div className="dsmovie-form-container">
            <img className="dsmovie-movie-card-image" src={movie?.image} alt={movie?.title} />
            <div className="dsmovie-card-bottom-container">
                <h3>{movie?.title}</h3>
                <form className="dsmovie-form" onSubmit={handleSubmit}>

                    <div className="form-group dsmovie-form-group">
                        <label htmlFor="email">Informe seu email</label>
                        {errors?.email && <p className="error">{errors?.email}</p>}
                        <input type="email"
                            className="form-control" id="email"
                            onChange={handleChange('email')} />
                    </div>

                    <div className="form-group dsmovie-form-group">
                        <label htmlFor="score">Informe sua avaliação</label>
                        {errors?.score && <p className="error">{errors?.score}</p>}
                        <select className="form-control" id="score" onChange={handleChange('score')} >
                            <option>Selecione...</option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>

                    <div className="dsmovie-button-bar">
                        <div className="dsmovie-form-btn-container">
                            <button type="submit" className="btn btn-primary dsmovie-btn"
                                disabled={errors != null} >
                                Salvar
                            </button>
                        </div>
                        <Link to="/" >
                            <button className="btn btn-primary dsmovie-btn">Cancelar</button>
                        </Link>
                    </div>
                </form >
            </div >
        </div >
    );
}


export default FormCard;