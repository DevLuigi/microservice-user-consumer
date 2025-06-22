
<div align="center">
    <h1> Microserviço - Consumer </h1>
</div>


<div align="center">
   <img src="http://img.shields.io/static/v1?label=STATUS&message=FINALIZADO&color=RED&style=for-the-badge" alt="badge-finalizado"/>
</div>

<br>

### Tópicos 

- [Descrição do projeto](#descrição-do-projeto)

- [Funcionalidades](#funcionalidades)

- [Ferramentas utilizadas](#ferramentas-utilizadas)

- [Acesso ao producer do projeto](#acesso-ao-producer-do-projeto)


<br>

## Descrição do projeto 
<p align="justify">
  Este projeto é um microserviço desenvolvido em Java com Spring Boot, responsável por consumir mensagens de uma fila do RabbitMQ (CloudAMQP) e enviar e-mails personalizados com templates HTML utilizando Thymeleaf.
</p>
<br>

## Objetivo
<p>
  O propósito deste microserviço é processar eventos relacionados ao cadastro de usuários, que são enviados por um sistema producer. Assim que uma nova mensagem é publicada na fila, o serviço a consome, processa os dados e envia um e-mail de boas-vindas ao usuário recém-cadastrado.
</p>
<br>

## Funcionalidades

:heavy_check_mark: `Funcionalidade 1:` Escutar mensagens da fila do RabbitMQ.

:heavy_check_mark: `Funcionalidade 2:` Deserializar a mensagem recebida.

:heavy_check_mark: `Funcionalidade 3:` Gerar e-mails com template HTML (Thymeleaf).

:heavy_check_mark: `Funcionalidade 4:` Enviar e-mail para o usuário cadastrado.

<br>

## Ferramentas utilizadas
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)

<br>

## Acesso ao producer do projeto

Você pode acessar o código fonte do projeto producer clicando aqui: [link](https://github.com/DevLuigi/microservice-user-producer).
