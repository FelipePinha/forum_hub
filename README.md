
# Forum Hub 💬

Forum Hub é uma API REST desenvolvida com **Spring Boot** como parte do programa **ONE** em parceria com a **Alura**. Seu objetivo é gerenciar tópicos de discussão em uma plataforma de cursos. Usuários podem se registrar, autenticar-se e interagir com tópicos relacionados aos cursos disponíveis.


## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Maven**

## 📚 Funcionalidades

A API permite:

- Registro e autenticação de usuários via JWT
- Criação, leitura, atualização e exclusão de tópicos
- Visualização de cursos com seus tópicos associados
- Paginação e ordenação de tópicos ativos

---

## 🔐 Autenticação

A autenticação é feita via token JWT. Após o login, o token deve ser enviado no header `Authorization` com o prefixo `Bearer`.

