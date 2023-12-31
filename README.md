### ECF3 - Gestion de Tournoi d'Échecs

## Description du projet

L'objectif de ce projet est de développer une application web utilisant les technologies suivantes :

- Spring Boot MVC
- Thymeleaf
- Spring Data
- Gestion de session
- Test Driven Development (TDD)

L'application permettra aux utilisateurs de s'inscrire et de participer à des tournois d'échecs. Elle fournira des fonctionnalités telles que la gestion des matches, l'affichage des classements et la consultation des profils des joueurs.

## Partie 1 : Conception et développement

### Page d'accueil
Créez une page d'accueil pour votre application. Cette page doit fournir une vue d'ensemble du tournoi, y compris une liste des prochains matches et des résultats des matches précédents.

### Page d'inscription/connexion
Développez une page d'inscription et de connexion. Les nouveaux utilisateurs doivent pouvoir s'inscrire à l'application, tandis que les utilisateurs existants doivent pouvoir se connecter. Une fois connectés, les utilisateurs doivent être redirigés vers leur page de profil.

### Page de profil
Chaque utilisateur doit disposer d'une page de profil, où il peut consulter et modifier ses informations personnelles. La page de profil doit afficher le classement actuel de l'utilisateur dans le tournoi, ainsi qu'un historique de ses matches.

### Page de gestion des matches
Développez une page de gestion des matches, où les utilisateurs peuvent voir la liste de leurs prochains matches. Les joueurs devraient pouvoir entrer les résultats des matches à partir de cette page. Les administrateurs du site devraient pouvoir programmer de nouveaux matches à partir d'une interface d'administration sécurisée.

### Page de classement
Créez une page de classement, qui affiche un classement de tous les participants au tournoi, triés par leur score.

### Intégration de Spring Data
Les modèles de données pour les joueurs, les matches et les résultats doivent être bien structurés et correctement persistés à l'aide de Spring Data.

### Gestion de session
Mettez en place un système de gestion de session pour gérer l'authentification des utilisateurs. Les utilisateurs doivent pouvoir se connecter et se déconnecter, et leurs sessions doivent persister entre différentes visites sur le site.

## Partie 2 : Test Driven Development

### Mise en œuvre du TDD
Choisissez une fonctionnalité de l'application et développez-la en utilisant la méthodologie TDD. Documentez votre processus, y compris l'écriture de tests, le développement de fonctionnalités pour passer les tests, et le refactoring.

## Comment démarrer l'application

1. Clonez le projet depuis le référentiel Git.

2. Configurez l'environnement de développement en installant les dépendances nécessaires.

3. Exécutez l'application en utilisant la commande suivante : `mvn spring-boot:run`.

4. Accédez à l'application dans votre navigateur en utilisant l'URL : `http://localhost:8080`.


---

