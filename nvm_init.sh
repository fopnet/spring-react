export NVM_DIR="$HOME/.nvm" &&
[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"  # This loads nvm
[ -s "$NVM_DIR/bash_completion" ] && \. "$NVM_DIR/bash_completion" &&  # This loads nvm bash_completion
source ~/.nvm/nvm.sh

echo "Original node version v10.19.0"
echo "Target node version v16.13.2"
echo "> command -v nvm"
echo "> nvm list"

