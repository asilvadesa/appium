# Appium
- O Appium é um framework para automação de testes para aplicativos mobile nativas ou hibridas tanto para dispositivos Android quanto IOS.

### Arquitetura do Appium
-  Appium utilizada uma arquitetura Cliente-Servidor
- Os scripts de testes podem ser escritos em diferentes linguagens
- Lista de bibliotecas de cliente com suporte para servidor Appium
  - Ruby
  - Python
  - Java
  - JavaScript
  - Objective C
  - PHP
  - C#
  - RobotFramework
  
 - [Para mais informações acesse a documentação](http://appium.io/docs/en/about-appium/intro/)

![alt text](https://thinkpalm.com/wp-content/uploads/2017/11/Appium-Architecture.jpg)


### Preparação do Ambiente (Ubuntu 20.04 LTS)
- Encontrei um material em inglês para a instalação do Appium para Ubuntu, para mais informações 
[clique aqui](https://confusedcoders.com/general-programming/mobile/how-to-install-appium-in-ubuntu). 

### Steps
### 1. Instalação das dependencias do Appium
  ```
  sudo apt-get install build-essential \
curl git m4 ruby texinfo libbz2-dev \
libcurl4-openssl-dev libexpat-dev libncurses-dev zlib1g-dev
  ```

### 2. Instalar linuxbrew

```
sh -c "$(curl -fsSL https://raw.githubusercontent.com/Linuxbrew/install/master/install.sh)"
```


### 3. Exportar variaveis 
- Você pode utilizar qualquer editor de texto (vim, nano, gedit) para adicionar as variaveis de ambiente

```
# Adicionar no final do bashrc
vim ~/.bashrc

export PATH="/home/linuxbrew/.linuxbrew/bin:$PATH"
export MANPATH="/home/linuxbrew/.linuxbrew/share/man:$MANPATH"
export INFOPATH="/home/linuxbrew/.linuxbrew/share/info:$INFOPATH"

# Source bashrc
source ~.bashrc

```

### 4. Instalar gcc

```
brew install gcc
```

### 5. Instalar node
```
brew update
brew install node
brew link node
```

### 6. Instalar o Appium
```
npm install -g appium
npm install wd
```

### 7. Inciar o Appium
```
$ appium
```
![alt text](https://github.com/asilvadesa/appium-test/blob/main/src/main/resources/imagens/start-appium.png)

- Se tudo estiver correto você vera essa mensagem no terminal, porem apesar do servidor está rodando é preciso verificar as dependencias que ele precisa para que o cliente consiga fazer a comunição, para isso vamos instalar uma ferramenta que nos auxilia para fazer essa checkagem.


### 8. Instalar Appium doctor
```
npm install appium-doctor -g
$ appium-doctor
```
![alt text](https://github.com/asilvadesa/appium-test/blob/main/src/main/resources/imagens/appium-doctor.png)

- Veja as dependencias que ainda faltavam e para isso basta adicionar as variaveis de ambiente no arquivo .bashrc

### 9. Configurando ANDROID_HOME e JAVA_HOME
```
vim ~/.bashrc

```
![alt text](https://github.com/asilvadesa/appium-test/blob/main/src/main/resources/imagens/variaveis-ambiente.png)

- Veja como ficou meu arquivo .bashrc ao final de todas as modicações
- Executa novamente após as alterações e o resultado final sera conforme a imagem a seguir.

![alt text](https://github.com/asilvadesa/appium-test/blob/main/src/main/resources/imagens/appium-doctor-success.png)

