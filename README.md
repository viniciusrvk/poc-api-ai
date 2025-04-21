
# Prova de Conceito - API de Chatbot com LLM

Este projeto é uma prova de conceito de uma API simples que integra com um modelo de linguagem (LLM) através do OpenRouter.

## 📚 Descrição

- A API expõe um endpoint REST (`POST /poc-api-ai/chat`) que recebe uma mensagem de texto e retorna uma resposta gerada pelo modelo.
- O modelo utilizado é configurável via `application.yml`.
- A integração com o OpenRouter é feita de forma compatível com a API padrão da OpenAI.

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- WebClient (Spring WebFlux)
- OpenRouter API (compatível OpenAI)
- Lombok
- HTML/CSS/JS simples para front-end de teste

## ⚙️ Como Rodar o Projeto

1. Configure seu `application.yml` com a chave da OpenRouter e modelo desejado.
2. Compile e execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
3. Acesse o front-end local (`index.html`) e envie mensagens para testar a comunicação com a API.

## 📄 Exemplo de Requisição

```bash
curl --location 'http://localhost:8080/poc-api-ai/chat' \
--header 'Content-Type: application/json' \
--data '{
    "message": "Qual o significado do acronomo LLM?"
}'
```

## 📄 Exemplo de Resposta

```json
{
    "response": "O acrônimo **LLM** pode ter diferentes significados dependendo do contexto. Os mais comuns são:\n\n1. **Large Language Model** (Modelo de Linguagem de Grande Escala):  \n   Refere-se a sistemas de inteligência artificial treinados em grandes volumes de dados para compreender e gerar texto em linguagem natural. Exemplos incluem o GPT, Gemini, LLaMA e outros. São usados em chatbots, tradução automática, geração de conteúdo e análise de texto.\n\n2. **Legum Magister** (Mestre em Direito):  \n   É um título acadêmico de pós-graduação em Direito, comum em países de tradição anglo-saxã (como **LL.M.**). É cursado após a graduação em Direito (como um Bachelor of Laws) para especialização em áreas específicas (ex.: direito internacional, tributário, etc.).\n\nSe você se refere ao contexto de tecnologia/IA, o primeiro significado é o mais relevante. 😊"
}
```

## 🖥️ Front-end de Teste

- Um arquivo `index.html` foi criado para facilitar o teste da API.
- O front-end inclui:
    - Área de digitação da mensagem.
    - Botão de envio (também acionado com a tecla Enter).
    - Área de resposta automática.
    - Modo escuro automático baseado nas preferências do navegador.
    - Bloqueio do botão enquanto aguarda a resposta da API.
