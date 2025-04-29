Plataforma Inteligente de Doação e Reaproveitamento de Alimentos

Estou criando uma plataforma social que conecta doadores de alimentos (como supermercados, feiras e restaurantes) com ONGs e comunidades em situação de vulnerabilidade.  
Ela também direciona alimentos impróprios para o consumo humano para compostagem ou biodigestores, promovendo a redução do desperdício e a economia circular.

---

## 🚀 Funcionalidades

✅ Cadastro de doadores e ONGs  
✅ Cadastro e classificação de doações (próprias para consumo ou para compostagem)  
✅ Reserva e retirada de doações por ONGs  
✅ Geração de pontuação e selos sociais para doadores  
✅ Visualização de doações por status  
✅ Integração com plano de compostagem  
✅ API REST construída com Spring Boot + JPA  
✅ Estrutura preparada para integração com IA (classificação automática futura)

---

## 🛠️ Tecnologias utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- H2
- Maven
- Postman (para testes)
- Git + GitHub

---

## 📁 Estrutura do Projeto

```plaintext
📂 src
 ┣ 📂 model         → Entidades JPA: Doacao, Doador, Usuario...
 ┣ 📂 controller    → Endpoints REST da API
 ┣ 📂 service       → Regras de negócio
 ┣ 📂 repository    → Acesso ao banco de dados
 ┣ 📂 config        → (Opcional) Configurações globais
 ┣ 📄 application.properties
