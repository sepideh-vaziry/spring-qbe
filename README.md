# Query by Example (QBE)
In Spring Boot, Query by Example (QBE) allows you to create queries dynamically based on the properties of a probe (an example object). 
This feature is helpful when you want to find entities by example without writing specific queries. Let's walk through a simple example.

## Testing the Complex Query
Now, you can test this complex query by calling the endpoint with different combinations. For example:

1. Partial name match (case-insensitive) and exact city match (case-insensitive):

    ```shell
    http://localhost:8080/api/v1/users?name=Jo&city=new york
    ```

2. Partial name match (case-insensitive) only:

    ```shell
    http://localhost:8080/api/v1/users?name=sep
    ```

3. Exact city match only:

    ```shell
    http://localhost:8080/api/v1/users?city=Tehran
    ```

With these combinations, the QBE example now supports more flexible, case-insensitive, and partial matching, 
giving you a powerful querying mechanism without writing explicit SQL or JPQL queries.