##ATIVIDADE PRÁTICA DAC - 17 06 2016
##passo 1 - Limpando e gerando a pasta target
mvn clean install

##passo 2 - Criando a imagem da aplicação
docker build -t jsf-app .

##passo 3 - Criando a imagem do banco de dados
-na pasta postgres, executar:
docker build -t jsf-db .

##passo 4 - Iniciando o container do banco
docker run -p 5432:5432 -d jsf-db

##passo 5 - Listando os containers em execução
docker ps

##passo 6 - Verificando a criação do banco e da tabela
docker exec -it <id-container> psql -U postgres dac-jsf

###listando as tabelas
dac-jsf=# \dt
###listando as tuplas da tabela pessoa
dac-jsf=# select * from pessoa;

##passo 6 - Iniciando o container da aplicação
docker run -ti -p 8080:8080 -p 4848:4848 -d jsf-app
