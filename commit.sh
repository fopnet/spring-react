if [ $# -eq 1 ]; then
	git add . &&
	git commit -m "$1" &&
	git push
else
	echo  "-------------------------------------------------------"
	echo  "Favor passar a mensagem como parâmetro"
	echo  "Exemplo commit \"ready to commit!\" "
	echo  "-------------------------------------------------------"
fi