# Açaí Manager App
Essa é uma API construída com Springboot, Hibernate, JPA e H2.

### Passos para execução
Para startar a aplicação, execute os seguintes comandos:

```
mvn clean package
docker-compose up -d
```

### Testes
Utilizando Postman, Insomnia ou qualquer outro aplicativo, pode-se realizar as seguintes requisições:

**ENDPOINT:** _http://localhost:8080/api/v1/pedidos_
1. Método GET: retornar os pedidos existentes.
2. Método POST: cria novos pedidos.
> Exemplo de requisição POST:
```
{
    {
    	"tamanho": "medio",
    	"fruta": "banana",
    	"adicionais": ["leite ninho"],
    	"tempoPreparo": 10
    }
}
```

**Valores possíveis**
1. Tamanho: pequeno, medio e grande
2. Fruta: morango, banana e kiwi
3. Adicionais: leite ninho, granola e paçoca

A variação de valores, frutas e adicionais produz um tempo de preparo e preço diferentes. Alguns desses dados podem conter um adicional de tempo ao tempo default fornecido na requisição, outros podem ter acréscimo de preço.
Esses dados são padronizados na base de dados, definidos inicialmente no arquivo **resources/data.sql**.