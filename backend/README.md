
1. Backend feito com spring com 3 perfis para os ambientes dev, test, prod

2. Perfis de acesso
2.1 dev -> local postgreSql
2.2 test -> h2 database
2.3 prod -> heroku postgreSql

3. TODO fazer uma implementação de repository para operar no Firebase database
Referencias: 
3.1 https://www.youtube.com/watch?v=uC2wvK79mBs
3.2 https://docs.spring.io/spring-cloud-gcp/docs/current/reference/html/firestore.html#_spring_data_cloud_firestore
3.3 https://medium.com/javarevisited/how-to-use-cloud-firestore-in-spring-boot-9a2e3bb0adca
3.4 https://github.com/googleapis/java-firestore/tree/main/samples/snippets/src/test/java/com/example/firestore

4. TODO pesquisar uma forma de trocar a fabrica no arquivo de propriedades no spring 
4.1 através de perfil prodFirebase por exempmlo
4.2 através de injeção de dependência com um Abstract Factory 
4.3 Usando dois repositórios ao mesmo tempo 
4.3.1 https://www.youtube.com/watch?v=MZF7IWRfKsA
4.3.2 https://www.youtube.com/watch?v=iDogrHEo4x0

5. Verificar uma forma de colocar os dados de conexão do Firebase no arquivo de propriedades
-> https://www.youtube.com/watch?v=uC2wvK79mBs