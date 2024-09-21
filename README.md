Tópicos Abordados
1. Relacionamentos entre Classes e Tabelas
Um-para-Um: Representa um relacionamento onde uma instância de uma entidade está associada a uma única instância de outra entidade.
Um-para-Muitos: Uma entidade pode estar relacionada a várias instâncias de outra entidade.
Muitos-para-Muitos: Ambas as entidades podem ter múltiplas instâncias relacionadas.
2. Anotação @Embedded
Usada para incluir uma classe que representa um conjunto de atributos que são mapeados como parte da entidade principal. Exemplo:

```
@Embeddable
public class Endereco {
    private String rua;
    private String cidade;
}
```

3. Anotações @CreationTimestamp e @UpdateTimestamp
@CreationTimestamp: Usada para preencher automaticamente a data e hora de criação de uma entidade.
@UpdateTimestamp: Usada para atualizar automaticamente a data e hora sempre que a entidade é atualizada.
Exemplo:

```
@Entity
public class Usuario {
    @Id
    private Long id;
    @CreationTimestamp
    private LocalDateTime dataCriacao;
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;
}
```

4. Eager Loading e Lazy Loading
Eager Loading: Carrega todas as entidades relacionadas imediatamente.
Lazy Loading: Carrega as entidades relacionadas apenas quando necessário. Configure com a anotação @OneToMany(fetch = FetchType.LAZY).
5. Versionamento com Flyway
Flyway é utilizado para gerenciar alterações no esquema do banco de dados. As migrações devem ser colocadas na pasta src/main/resources/db/migration.

6. População de tabelas com Flyway
Como adicionar dados em tabelas no ambiente de desenvolvimento.
