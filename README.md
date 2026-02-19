# 🛒 Product Management Microservice

[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.2-green.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9.12-blue.svg)](https://maven.apache.org)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](./LICENSE)

Une application **Spring Boot** pour la gestion des produits. API RESTful complète pour créer, lire, mettre à jour et supprimer des produits.

---

## 📺 See It in Action

<iframe src="https://drive.google.com/file/d/1sB27O8g2sVW5L-a6xSJJoVr6W5c_xmL4/preview" width="100%" height="600" allow="autoplay" allowfullscreen></iframe>

---

## ⚡ Quick Start

### Installation

```bash
git clone https://github.com/ABDELALIKHOLTY/Product-Management-Microservice.git
cd product
mvn clean install
```

### Démarrer l'application

```bash
mvn spring-boot:run
```

Ou avec un port personnalisé :
```bash
java -jar target/product-0.0.1-SNAPSHOT.jar --server.port=8081
```

**Accès** :
- 🌐 API : http://localhost:8080/api/products
- 💾 H2 Console : http://localhost:8080/h2-console

---

## 📋 API Endpoints

| Méthode | Endpoint | Description |
|---------|----------|-------------|
| `GET` | `/api/products` | Récupérer tous les produits |
| `GET` | `/api/products/{id}` | Récupérer un produit par ID |
| `POST` | `/api/products` | Créer un nouveau produit |
| `PUT` | `/api/products/{id}` | Mettre à jour un produit |
| `DELETE` | `/api/products/{id}` | Supprimer un produit |

### Exemple d'utilisation

```bash
# Créer
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Laptop","price":999}'

# Récupérer
curl http://localhost:8080/api/products
```

### Format des produits

```json
{
  "id": 1,
  "name": "Laptop",
  "price": 999
}
```

---

## 🛠️ Technologies

- **Spring Boot** 4.0.2
- **Java** 17+
- **H2 Database** (embarquée)
- **Maven** 3.9.12
- **JPA/Hibernate**

---

## 👤 Auteur

**Abdel** - Développement et documentation

---

## 📄 Licence

MIT License - Voir LICENSE pour détails
