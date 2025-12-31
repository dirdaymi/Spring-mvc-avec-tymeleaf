# 📦 Application de Gestion de Produits (Product Management App)

Ce projet est une application Web complète développée avec **Spring Boot** et **Thymeleaf**. Elle a été réalisée dans le cadre d'un Travail Pratique (TP) pour comprendre l'architecture MVC, la persistance des données avec JPA, et la sécurisation avec Spring Security.

L'objectif est de fournir une interface permettant de gérer un stock de produits (CRUD : Créer, Lire, Mettre à jour, Supprimer) avec différents niveaux de droits d'accès.

## 🚀 Fonctionnalités Principales

* **Consultation :** Affichage de la liste des produits avec pagination.
* **Recherche :** Barre de recherche par mot-clé (ex: "Computer").
* **Administration :** Ajout, Modification et Suppression de produits.
* **Sécurité :**
    * Authentification par formulaire (Login).
    * Gestion des rôles (USER vs ADMIN).
    * Protection des routes (seul un ADMIN peut supprimer/éditer).
* **Interface :** Design responsive utilisant **Bootstrap 5**.

---

## 📸 Aperçu de l'application

Voici quelques captures d'écran illustrant le fonctionnement de l'application.

# 📦 Application de Gestion de Produits (Product Management App)

Ce projet est une application Web complète développée avec **Spring Boot** et **Thymeleaf**. Elle a été réalisée dans le cadre d'un Travail Pratique (TP) pour comprendre l'architecture MVC, la persistance des données avec JPA, et la sécurisation avec Spring Security.

L'objectif est de fournir une interface permettant de gérer un stock de produits (CRUD : Créer, Lire, Mettre à jour, Supprimer) avec différents niveaux de droits d'accès.

## 🚀 Fonctionnalités Principales

* **Consultation :** Affichage de la liste des produits avec pagination.
* **Recherche :** Barre de recherche par mot-clé (ex: "Computer").
* **Administration :** Ajout, Modification et Suppression de produits.
* **Sécurité :**
    * Authentification par formulaire (Login).
    * Gestion des rôles (USER vs ADMIN).
    * Protection des routes (seul un ADMIN peut supprimer/éditer).
* **Interface :** Design responsive utilisant **Bootstrap 5**.

---

## 📸 Aperçu de l'application

Voici quelques captures d'écran illustrant le fonctionnement de l'application.

### 1. Liste des Produits
Une fois authentifié, on accède à la liste des produits. On peut voir ici les produits (Computer, Printer, etc.) avec les boutons d'actions (Supprimer/Éditer) car je suis connecté en Admin.
![Liste des produits](captures/captures%2010%20(4).png)

### 2. Modification d'un Produit
Voici le formulaire d'édition. Par exemple, ici nous modifions le produit "Computer". Les champs sont pré-remplis avec les données existantes.
![Formulaire Edition](captures/captures%2010%20(1).png)

### 3. Structure du Code (IntelliJ IDEA)
L'architecture du projet respecte les standards Spring Boot :
* `entities` pour les données (Product).
* `repository` pour la base de données.
* `web` pour les contrôleurs.
* `security` pour la configuration des accès.
![Structure Projet](captures/captures%2010%20(2).jpg)

### 4. Base de Données (Console H2)
Les données sont stockées dans une base de données embarquée H2.
![Console H2](captures/captures%2010%20(3).png)

---

## 🛠️ Stack Technique

* **Java 17** : Langage principal.
* **Spring Boot 3.2** : Framework backend.
* **Spring Data JPA** : Gestion de la persistance des données (DAO).
* **H2 Database** : Base de données embarquée (en mémoire).
* **Thymeleaf** : Moteur de template pour la vue (Frontend).
* **Spring Security** : Gestion de l'authentification et des autorisations.
* **Bootstrap 5** : Framework CSS pour le design.
* **Maven** : Gestionnaire de dépendances.

---

## ⚙️ Configuration & Installation

Pour lancer ce projet localement, suivez ces étapes :

### 1. Prérequis
* JDK 17 installé.
* Maven installé.
* Un IDE (IntelliJ IDEA recommandé, ou Eclipse/VS Code).

### 2. Démarrage
Clonez le dépôt et lancez la classe principale `TpSpringMvcApplication.java`.
L'application démarrera sur le port **8094**.

Accédez à l'application via :
> **http://localhost:8094/user/index**

### 3. Comptes de Test (Authentification)
La sécurité est activée par défaut. Voici les utilisateurs configurés en mémoire (`SecurityConfig.java`) :

| Username | Password | Rôles | Droits |
| :--- | :--- | :--- | :--- |
| **user1** | 1234 | USER | Voir la liste, Chercher |
| **admin** | 1234 | USER, ADMIN | Voir, Chercher, **Ajouter, Modifier, Supprimer** |

---

## 🗄️ Accès à la Base de Données (H2)

Pour vérifier les données brutes, vous pouvez accéder à la console H2.

* **URL Console :** [http://localhost:8094/h2-console](http://localhost:8094/h2-console)
* **Configuration JDBC (Important) :**
    * Driver Class : `org.h2.Driver`
    * JDBC URL : `jdbc:h2:mem:productsDB`  
    * User Name : `sa`
    * Password : (laisser vide)

> **Note :** Comme c'est une base "in-memory" (`mem`), les données sont réinitialisées à chaque redémarrage de l'application. Le `CommandLineRunner` se charge d'insérer 4 produits par défaut au démarrage.

---

## 📂 Structure du Projet

* `entities` : Contient la classe `Product` (JPA Entity).
* `repository` : Interface `ProductRepository` pour les requêtes SQL.
* `web` : Les contrôleurs (`ProductController`, `SecurityController`) qui gèrent les requêtes HTTP.
* `security` : Configuration des droits d'accès (`SecurityConfig`).
* `resources/templates` : Les fichiers HTML Thymeleaf (`products.html`, `formProducts.html`, etc.).

---

## 📝 Auteur
**Abdel-hamid Mahamat Louki**
*Élève Ingénieur en Informatique - Université Mundiapolis*

---

## 🛠️ Stack Technique

* **Java 17** : Langage principal.
* **Spring Boot 3.2** : Framework backend.
* **Spring Data JPA** : Gestion de la persistance des données (DAO).
* **H2 Database** : Base de données embarquée (en mémoire).
* **Thymeleaf** : Moteur de template pour la vue (Frontend).
* **Spring Security** : Gestion de l'authentification et des autorisations.
* **Bootstrap 5** : Framework CSS pour le design.
* **Maven** : Gestionnaire de dépendances.

---

## ⚙️ Configuration & Installation

Pour lancer ce projet localement, suivez ces étapes :

### 1. Prérequis
* JDK 17 installé.
* Maven installé.
* Un IDE (IntelliJ IDEA recommandé, ou Eclipse/VS Code).

### 2. Démarrage
Clonez le dépôt et lancez la classe principale `TpSpringMvcApplication.java`.
L'application démarrera sur le port **8094**.

Accédez à l'application via :
> **http://localhost:8094/user/index**

### 3. Comptes de Test (Authentification)
La sécurité est activée par défaut. Voici les utilisateurs configurés en mémoire (`SecurityConfig.java`) :

| Username | Password | Rôles | Droits |
| :--- | :--- | :--- | :--- |
| **user1** | 1234 | USER | Voir la liste, Chercher |
| **admin** | 1234 | USER, ADMIN | Voir, Chercher, **Ajouter, Modifier, Supprimer** |

---

## 🗄️ Accès à la Base de Données (H2)

Pour vérifier les données brutes, vous pouvez accéder à la console H2.

* **URL Console :** [http://localhost:8094/h2-console](http://localhost:8094/h2-console)
* **Configuration JDBC (Important) :**
    * Driver Class : `org.h2.Driver`
    * JDBC URL : `jdbc:h2:mem:productsDB`  *(⚠️ Attention : ne pas utiliser `~/test`)*
    * User Name : `sa`
    * Password : (laisser vide)

> **Note :** Comme c'est une base "in-memory" (`mem`), les données sont réinitialisées à chaque redémarrage de l'application. Le `CommandLineRunner` se charge d'insérer 4 produits par défaut au démarrage.

---

## 📂 Structure du Projet

* `entities` : Contient la classe `Product` (JPA Entity).
* `repository` : Interface `ProductRepository` pour les requêtes SQL.
* `web` : Les contrôleurs (`ProductController`, `SecurityController`) qui gèrent les requêtes HTTP.
* `security` : Configuration des droits d'accès (`SecurityConfig`).
* `resources/templates` : Les fichiers HTML Thymeleaf (`products.html`, `formProducts.html`, etc.).

---

## 📝 Auteur
**Abdel-hamid Mahamat Louki**
*Élève Ingénieur en Informatique - Université Mundiapolis*
