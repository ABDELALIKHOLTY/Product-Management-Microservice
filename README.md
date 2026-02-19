# 🛒 Product Management Microservice

[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.2-green.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9.12-blue.svg)](https://maven.apache.org)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](./LICENSE)

**Project Name:** Product Management Microservice

**Technology Stack:** Spring Boot 4.0.2 + H2 Database + REST API

**Architecture:** Microservice with CRUD Operations & JPA/Hibernate ORM

**Core API:** RESTful endpoints for complete product lifecycle management

## 1. Executive Summary

This is a fully functional **Spring Boot microservice** designed for managing product inventory. The system provides a complete REST API for Create, Read, Update, and Delete (CRUD) operations on products. It leverages **H2 Database** for data persistence, **JPA/Hibernate** for object-relational mapping, and includes an interactive **H2 Console** for direct database access. The application is production-ready and can be deployed locally or in containerized environments.

---

## 📋 Table des matières

- [Vidéo de Démonstration](#vidéo-de-démonstration)
- [Fonctionnalités](#fonctionnalités)
- [Prérequis](#prérequis)
- [Installation](#installation)
- [Configuration](#configuration)
- [Utilisation](#utilisation)
- [Endpoints API](#endpoints-api)
- [Structure du Projet](#structure-du-projet)
- [Technologies Utilisées](#technologies-utilisées)
- [Dépannage](#dépannage)
- [Auteur](#auteur)

---

## � See It in Action

[public/video.mp4](./public/video.mp4)

---

## 2. Product Architecture & Features

### 2.1 Core Capabilities

The microservice includes the following features:

- ✅ **Complete CRUD Operations** : Create, read, update, and delete products
- ✅ **H2 Embedded Database** : Lightweight database for development and testing
- ✅ **RESTful API Design** : Standard HTTP methods (GET, POST, PUT, DELETE)
- ✅ **JPA/Hibernate ORM** : Automatic mapping between Java objects and database tables
- ✅ **H2 Web Console** : Interactive database management interface
- ✅ **Spring DevTools** : Automatic restart during development for faster iteration

### 2.2 Data Model

**Product Entity** - Stores product information with the following attributes:

| Attribute | Type | Required | Description |
| :--- | :--- | :--- | :--- |
| **id** | Integer | Yes (Auto-generated) | Unique product identifier |
| **name** | String | Yes | Product name or description |
| **price** | Integer | Yes | Product price in currency units |

---

## 3. System Requirements & Setup

### 3.1 Prerequisites

Before deploying this microservice, ensure the following are installed:

- **Java 17 or Higher** : [Download Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Maven 3.6+** : [Download Maven](https://maven.apache.org/download.cgi)
- **Git** : [Download Git](https://git-scm.com/)

### 3.2 Verify Installation

```bash
java -version
mvn --version
git --version
```

---

## 4. Getting Started

### Fichier `application.properties`

Le fichier de configuration se trouve dans `src/main/resources/application.properties`

```properties
# Port du serveur
server.port=8081

# Configuration H2 Database
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Configuration JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

# H2 Console
spring.h2.console.enabled=true
```

### Configuration personnalisée

- **Port** : Modifier `server.port` dans `application.properties` ou en ligne de commande
- **Base de données** : Changer l'URL et les paramètres de connexion selon votre BD

---

## 🚀 Utilisation

### Démarrer l'application

#### Option 1 : Avec Maven
```bash
mvn spring-boot:run
```

#### Option 2 : Avec le JAR packagé
```bash
mvn clean package
java -jar target/product-0.0.1-SNAPSHOT.jar
```

#### Option 3 : Sur un port personnalisé
```bash
java -jar target/product-0.0.1-SNAPSHOT.jar --server.port=8081
```

### Accéder à l'application

- **API Principale** : [http://localhost:8080](http://localhost:8080)
- **H2 Console** : [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

## 📡 Endpoints API

### Base URL
```
http://localhost:8080/api/products
```

### Endpoints disponibles

#### 1. Récupérer tous les produits
```http
GET /api/products
```

**Réponse (200)** :
```json
[
  {
    "id": 1,
    "name": "Produit A",
    "price": 29.99
  }
]
```

#### 2. Récupérer un produit par ID
```http
GET /api/products/{id}
```

**Exemple** :
```
GET /api/products/1
```

**Réponse (200)** :
```json
{
  "id": 1,
  "name": "Produit A",
  "price": 29.99
}
```

#### 3. Créer un nouveau produit
```http
POST /api/products
Content-Type: application/json
```

**Body** :
```json
{
  "name": "Nouveau Produit",
  "price": 49.99
}
```

**Réponse (201)** :
```json
{
  "id": 2,
  "name": "Nouveau Produit",
  "price": 49.99
}
```

#### 4. Mettre à jour un produit
```http
PUT /api/products/{id}
Content-Type: application/json
```

**Body** :
```json
{
  "name": "Produit Mis à Jour",
  "price": 59.99
}
```

**Réponse (200)** :
```json
{
  "id": 1,
  "name": "Produit Mis à Jour",
  "price": 59.99
}
```

#### 5. Supprimer un produit
```http
DELETE /api/products/{id}
```

**Réponse (204)** : Pas de contenu

---

## 📂 Structure du Projet

```
product/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/product/
│   │   │       ├── ProductApplication.java          # Point d'entrée Spring Boot
│   │   │       ├── controller/
│   │   │       │   └── ProductController.java        # Endpoints REST
│   │   │       ├── model/
│   │   │       │   └── Product.java                 # Entité produit
│   │   │       ├── repository/
│   │   │       │   └── ProductRepo.java              # Accès à la base de données
│   │   │       └── service/
│   │   │           └── ProductService.java           # Logique métier
│   │   └── resources/
│   │       └── application.properties                # Configuration
│   └── test/
│       └── java/
│           └── com/example/product/
│               └── ProductApplicationTests.java      # Tests unitaires
├── pom.xml                                          # Dépendances Maven
├── README.md                                        # Ce fichier
└── target/                                          # Résultats de compilation
```

---

## 🛠️ Technologies Utilisées

| Technologie | Version | Description |
|---|---|---|
| **Spring Boot** | 4.0.2 | Framework web Java |
| **Spring Data JPA** | - | Accès aux données avec JPA |
| **H2 Database** | - | Base de données embarquée |
| **Hibernate** | - | ORM (Object-Relational Mapping) |
| **Maven** | 3.9.12 | Gestion des dépendances |
| **Java** | 17+ | Langage de programmation |
| **Spring DevTools** | - | Développement productif |

---

## 🐛 Dépannage

### Port déjà utilisé

**Problème** :
```
Port 8080 was already in use
```

**Solution** : Utilisez un port différent
```bash
java -jar target/product-0.0.1-SNAPSHOT.jar --server.port=8081
```

### Erreur de compilation

**Problème** : Compilation échouée

**Solution** :
```bash
# Nettoyer et reconstruire
mvn clean install -DskipTests=true
```

### Base de données non initialisée

**Problème** : Erreurs de connexion à la base de données

**Solution** : 
1. Vérifier que H2 est dans les dépendances
2. Redémarrer l'application
3. Consulter les logs pour plus de détails

### Accès à H2 Console

**URL** : [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

**Credentials par défaut** :
- Username : `sa`
- Password : (vide)
- JDBC URL : `jdbc:h2:mem:testdb`

---

## 📝 Exemple d'utilisation avec cURL

```bash
# Créer un produit
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Laptop","price":999.99}'

# Récupérer tous les produits
curl http://localhost:8080/api/products

# Récupérer un produit
curl http://localhost:8080/api/products/1

# Mettre à jour un produit
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Updated Laptop","price":1099.99}'

# Supprimer un produit
curl -X DELETE http://localhost:8080/api/products/1
```

---

## 👤 Auteur

**Projet créé et grandi par** : **Abdel**

### Crédits
- 💻 **Développement** : Abdel
- 🎥 **Vidéo de démonstration** : Abdel
- 📝 **Documentation** : Abdel

### Contact
Pour toute question, suggestion ou collaboration, vous pouvez me contacter.

---

## 📄 Licence

Ce projet est distribué sous la licence MIT. Voir le fichier LICENSE pour plus de détails.

---

## 🤝 Contribution

Les contributions sont bienvenues ! Pour contribuer :

1. Forker le projet
2. Créer une branche (`git checkout -b feature/AmazingFeature`)
3. Commiter les changements (`git commit -m 'Add some AmazingFeature'`)
4. Pousser vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrir une Pull Request

---

## 📞 Support

Pour toute question ou problème, veuillez ouvrir une issue sur le dépôt GitHub.

---

**Dernière mise à jour** : Février 2026
