# Screen Sound Músicas

## Descrição do Projeto

O projeto "Screen Sound Músicas" é uma aplicação Java que permite o gerenciamento de músicas e artistas. Nela, é possível cadastrar artistas, cadastrar músicas, listar as músicas cadastradas, buscar músicas por artista e pesquisar informações sobre um artista utilizando a API do ChatGPT.

## Funcionalidades

1. Cadastrar artistas
2. Cadastrar músicas
3. Listar músicas
4. Buscar músicas por artista
5. Pesquisar dados sobre um artista

## Modelo de Domínio

O modelo de domínio do projeto é composto pelas seguintes classes:

```mermaid
classDiagram
    **class** **Artista** {
        -id: Long
        -nome: String
        -tipo: TipoArtista
        +cadastrarMusica(Musica)
    }

    **class** **Musica** {
        -id: Long
        -nome: String
        -artista: Artista
    }

    **class** **TipoArtista** {
        <<enumeration>>
        SOLO
        DUPLA
        BANDA
    }

    Artista "1" -- "0..*" Musica : canta
```

## Etapas para Resolução do Desafio

1. **Configurar o Projeto**: Crie um novo projeto Java e configure as dependências necessárias, como o Spring Data JPA e a integração com o ChatGPT.
2. **Implementar as Entidades**: Crie as classes `Artista`, `Musica` e `TipoArtista` de acordo com o modelo de domínio apresentado.
3. **Implementar os Repositórios**: Crie os repositórios JPA para as entidades `Artista` e `Musica`.
4. **Implementar os Serviços**: Crie os serviços para as funcionalidades de cadastro de artistas, cadastro de músicas, listagem de músicas, busca de músicas por artista e pesquisa de informações sobre um artista.
5. **Implementar a Integração com o ChatGPT**: Implemente a funcionalidade de pesquisa de informações sobre um artista utilizando a API do ChatGPT.
6. **Implementar a Interface de Usuário**: Crie uma interface de usuário (CLI, Web, etc.) para interagir com a aplicação.
7. **Documentação**: Crie a documentação do projeto, incluindo instruções de instalação, uso e contribuição.