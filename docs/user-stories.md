# IndieNest Backend -- REST API Technical Stories

## Overview
This document contains API-focused technical stories 
intended for frontend developers integrating
with the IndieNest Backend REST API
(Java, Spring Boot).

Common conventions
- Base path: `/api/v1`


### TS-G001 -- Create a Game
As a frontend developer, I want to create a new Game through the API so that I can add games to the system as a feature in my application.

Acceptance criteria:
- Scenario: Successful create
    - Given a POST request to `/api/v1/games` is received with a request body containing the create-game attributes: authorId, name, description, rating, price, category, image.  
    - When the API validates and persists the game
    - Then the API responds with `201 Created` and returns the created game with attributes: id (Int), authorId(Integer), name(String), description(String), rating(Integer), creationDate(Date), price(Float), category(GameCategory), image(String).
- Scenario: Validation error
    - Given a POST request to `/api/v1/games` is received with missing or invalid create-game attributes (e.g., empty name or description)
    - When the API validates the request and detects validation errors
    - Then the API responds with `400 Bad Request` and returns an error payload describing validation errors.

---

### TS-G002 -- Get a Game by id
As a frontend developer, I want to fetch a game by its `{id}` through the API, so that I can show game information as a feature in my application.

Acceptance criteria:
- Scenario: Found
    - Given a GET request to `/api/v1/games/{id}` is received
    - When the API finds the game
    - Then the API responds `200 OK` and returns the game with attributes: id (Int), authorId(Integer), name(String), description(String), rating(Integer), creationDate(Date), price(Float), category(GameCategory), image(String).
- Scenario: Not found
    - Given a GET request to `/api/v1/games/{id}` is received for a non-existent `{id}`
    - When the API does not find the game
    - Then the API responds `404 Not Found` and returns an error payload.

---

### TS-G003 -- Get all Games
As a frontend developer, I want to list all games through the API so that I can show them in a catalogue as a feature in my application.

Acceptance criteria:
- Scenario: games exist
    - Given a GET request to `/api/v1/games` is received
    - When the API finds one or more games
    - Then the API responds `200 OK` and returns a list where each item contains the game attributes: id (Int), authorId(Integer), name(String), description(String), rating(Integer), creationDate(Date), price(Float), category(GameCategory), image(String).
- Scenario: No games found
    - Given a GET request to `/api/v1/games` is received and there are no games in the system
    - When the API searches for games and finds none
    - Then the API responds `404 Not Found` (per current controller behavior) and returns an appropriate error payload.

---

### TS-AU001 -- Create an Audio
As a frontend developer, I want to create a new Audio through the API so that I can add audios to the system as a feature in my application.

Acceptance criteria:
- Scenario: Successful create
    - Given a POST request to `/api/v1/audios` is received with a request body containing the create-audio attributes: authorId, name, description, rating, image, audioUrl, format, category.
    - When the API validates and persists the audio
    - Then the API responds with `201 Created` and returns the created audio with attributes: id (Int), authorId(Integer), name(String), description(String), rating(Integer), creationDate(Date), image(String), audioUrl(String), format(String) category(AudioCategory).
- Scenario: Validation error
    - Given a POST request to `/api/v1/audios` is received with missing or invalid create-audio attributes (e.g., empty name or description)
    - When the API validates the request and detects validation errors
    - Then the API responds with `400 Bad Request` and returns an error payload describing validation errors.

---

### TS-AU002 -- Get an Audio by id
As a frontend developer, I want to fetch an audio by its `{id}` through the API, so that I can show audio information as a feature in my application.

Acceptance criteria:
- Scenario: Found
    - Given a GET request to `/api/v1/audios/{id}` is received
    - When the API finds the audio
    - Then the API responds `200 OK` and returns the audio with attributes: id (Int), authorId(Integer), name(String), description(String), rating(Integer), creationDate(Date), image(String), audioUrl(String), format(String) category(AudioCategory).
- Scenario: Not found
    - Given a GET request to `/api/v1/audios/{id}` is received for a non-existent `{id}`
    - When the API does not find the audio
    - Then the API responds `404 Not Found` and returns an error payload.

---

### TS-AU003 -- Get all Audios
As a frontend developer, I want to list all audios through the API so that I can show them in a catalogue as a feature in my application.

Acceptance criteria:
- Scenario: audios exist
    - Given a GET request to `/api/v1/audios` is received
    - When the API finds one or more audios
    - Then the API responds `200 OK` and returns a list where each item contains the audio attributes: id (Int), authorId(Integer), name(String), description(String), rating(Integer), creationDate(Date), image(String), audioUrl(String), format(String) category(AudioCategory).
- Scenario: No audios found
    - Given a GET request to `/api/v1/audios` is received and there are no audios in the system
    - When the API searches for audios and finds none
    - Then the API responds `404 Not Found` (per current controller behavior) and returns an appropriate error payload.

---

### TS-AR001 -- Create an Art
As a frontend developer, I want to create a new Art through the API so that I can add arts to the system as a feature in my application.

Acceptance criteria:
- Scenario: Successful create
    - Given a POST request to `/api/v1/arts` is received with a request body containing the create-art attributes: authorId, name, description, rating, image, category.
    - When the API validates and persists the art
    - Then the API responds with `201 Created` and returns the created art with attributes: id (Int), authorId(Integer), name(String), description(String), rating(Integer), creationDate(Date), image(String), category(ArtCategory).
- Scenario: Validation error
    - Given a POST request to `/api/v1/arts` is received with missing or invalid create-art attributes (e.g., empty name or description)
    - When the API validates the request and detects validation errors
    - Then the API responds with `400 Bad Request` and returns an error payload describing validation errors.

---

### TS-AR002 -- Get an Art by id
As a frontend developer, I want to fetch an art by its `{id}` through the API, so that I can show art information as a feature in my application.

Acceptance criteria:
- Scenario: Found
    - Given a GET request to `/api/v1/arts/{id}` is received
    - When the API finds the art
    - Then the API responds `200 OK` and returns the art with attributes: id (Int), authorId(Integer), name(String), description(String), rating(Integer), creationDate(Date), image(String), category(ArtCategory).
- Scenario: Not found
    - Given a GET request to `/api/v1/arts/{id}` is received for a non-existent `{id}`
    - When the API does not find the art
    - Then the API responds `404 Not Found` and returns an error payload.

---

### TS-AR003 -- Get all Arts
As a frontend developer, I want to list all arts through the API so that I can show them in a catalogue as a feature in my application.

Acceptance criteria:
- Scenario: arts exist
    - Given a GET request to `/api/v1/arts` is received
    - When the API finds one or more arts
    - Then the API responds `200 OK` and returns a list where each item contains the art attributes: id (Int), authorId(Integer), name(String), description(String), rating(Integer), creationDate(Date), image(String), category(ArtCategory).
- Scenario: No arts found
    - Given a GET request to `/api/v1/arts` is received and there are no arts in the system
    - When the API searches for arts and finds none
    - Then the API responds `404 Not Found` (per current controller behavior) and returns an appropriate error payload.

---

### TS-U001 -- Create a User
As a frontend developer, I want to create a new User through the API so that I can add users to the system as a feature in my application.

Acceptance criteria:
- Scenario: Successful create
    - Given a POST request to `/api/v1/users` is received with a request body containing the create-user attributes: name, phoneNumber
    - When the API validates and persists the user
    - Then the API responds with `201 Created` and returns the created user with attributes: id (Int), name(String), phoneNumber(String).
- Scenario: Validation error
    - Given a POST request to `/api/v1/users` is received with missing or invalid create-user attributes (e.g., empty name or phoneNumber)
    - When the API validates the request and detects validation errors
    - Then the API responds with `400 Bad Request` and returns an error payload describing validation errors.

---

### TS-U002 -- Get a User by id
As a frontend developer, I want to fetch a user by its `{id}` through the API, so that I can show user information as a feature in my application.

Acceptance criteria:
- Scenario: Found
    - Given a GET request to `/api/v1/users/{id}` is received
    - When the API finds the user
    - Then the API responds `200 OK` and returns the user with attributes: id (Int), name(String), phoneNumber(String).
- Scenario: Not found
    - Given a GET request to `/api/v1/users/{id}` is received for a non-existent `{id}`
    - When the API does not find the user
    - Then the API responds `404 Not Found` and returns an error payload.

---

### TS-U003 -- Get all Users
As a frontend developer, I want to list all users through the API so that I can show them in a catalogue as a feature in my application.

Acceptance criteria:
- Scenario: users exist
    - Given a GET request to `/api/v1/users` is received
    - When the API finds one or more users
    - Then the API responds `200 OK` and returns a list where each item contains the user attributes: id (Int), name(String), phoneNumber(String).
- Scenario: No users found
    - Given a GET request to `/api/v1/users` is received and there are no users in the system
    - When the API searches for users and finds none
    - Then the API responds `404 Not Found` (per current controller behavior) and returns an appropriate error payload.

---

### TS-AC001 -- Create an Account
As a frontend developer, I want to create a new Account through the API so that I can add accounts to the system as a feature in my application.

Acceptance criteria:
- Scenario: Successful create
    - Given a POST request to `/api/v1/accounts` is received with a request body containing the create-account attributes: userId, email, password, role.
    - When the API validates and persists the account
    - Then the API responds with `201 Created` and returns the created account with attributes: id (Int), userId(Int), email(String), password(String), isActive(Boolean) role(AccountType).
- Scenario: Validation error
    - Given a POST request to `/api/v1/accounts` is received with missing or invalid create-account attributes (e.g., empty email or password)
    - When the API validates the request and detects validation errors
    - Then the API responds with `400 Bad Request` and returns an error payload describing validation errors.

---

### TS-AC002 -- Get an Account by id
As a frontend developer, I want to fetch an account by its `{id}` through the API, so that I can show account information as a feature in my application.

Acceptance criteria:
- Scenario: Found
    - Given a GET request to `/api/v1/accounts/{id}` is received
    - When the API finds the account
    - Then the API responds `200 OK` and returns the account with attributes: id (Int), userId(Int), email(String), password(String), isActive(Boolean) role(AccountType).
- Scenario: Not found
    - Given a GET request to `/api/v1/accounts/{id}` is received for a non-existent `{id}`
    - When the API does not find the account
    - Then the API responds `404 Not Found` and returns an error payload.

---

### TS-AC003 -- Get all Accounts
As a frontend developer, I want to list all accounts through the API so that I can show them in a catalogue as a feature in my application.

Acceptance criteria:
- Scenario: accounts exist
    - Given a GET request to `/api/v1/accounts` is received
    - When the API finds one or more accounts
    - Then the API responds `200 OK` and returns a list where each item contains the account attributes: id (Int), userId(Int), email(String), password(String), isActive(Boolean) role(AccountType).
- Scenario: No accounts found
    - Given a GET request to `/api/v1/accounts` is received and there are no accounts in the system
    - When the API searches for accounts and finds none
    - Then the API responds `404 Not Found` (per current controller behavior) and returns an appropriate error payload.

---

### TS-PO001 -- Create a Portfolio
As a frontend developer, I want to create a new Portfolio through the API so that I can add portfolios to the system as a feature in my application.

Acceptance criteria:
- Scenario: Successful create
    - Given a POST request to `/api/v1/portfolios` is received.
    - When the API validates and persists the portfolio
    - Then the API responds with `201 Created` and returns the created portfolio with attributes: id (Int), creationDate(Date), gameIds(Int[]), audioIds(Int[]), artIds(Int[]).

---

### TS-PO002 -- Get a Portfolio by id
As a frontend developer, I want to fetch a portfolio by its `{id}` through the API, so that I can show portfolio information as a feature in my application.

Acceptance criteria:
- Scenario: Found
    - Given a GET request to `/api/v1/portfolios/{id}` is received
    - When the API finds the portfolio
    - Then the API responds `200 OK` and returns the portfolio with attributes: id (Int), creationDate(Date), gameIds(Int[]), audioIds(Int[]), artIds(Int[]).
- Scenario: Not found
    - Given a GET request to `/api/v1/portfolios/{id}` is received for a non-existent `{id}`
    - When the API does not find the portfolio
    - Then the API responds `404 Not Found` and returns an error payload.

---

### TS-PO003 -- Get all Portfolios
As a frontend developer, I want to list all portfolios through the API so that I can show them in a catalogue as a feature in my application.

Acceptance criteria:
- Scenario: portfolios exist
    - Given a GET request to `/api/v1/portfolios` is received
    - When the API finds one or more portfolios
    - Then the API responds `200 OK` and returns a list where each item contains the portfolio attributes: id (Int), creationDate(Date), gameIds(Int[]), audioIds(Int[]), artIds(Int[]).
- Scenario: No portfolios found
    - Given a GET request to `/api/v1/portfolios` is received and there are no portfolios in the system
    - When the API searches for portfolios and finds none
    - Then the API responds `404 Not Found` (per current controller behavior) and returns an appropriate error payload.

---

### TS-PO004 -- Update Portfolio by id and updated Portfolio
As a frontend developer, I want to update a portfolio by its `{id}` through the API, so that I can update portfolio information as a feature in my application.

Acceptance criteria:
- Scenario: Found
    - Given a PUT request to `/api/v1/portfolios/{id}` is received with a request body containing the updated-portfolio attributes: gameIds, audioIds, artIds.
    - When the API finds the portfolio and update it.
    - Then the API responds `200 OK` and returns the portfolio with attributes: id (Int), creationDate(Date), gameIds(Int[]), audioIds(Int[]), artIds(Int[]).
- Scenario: Not found
    - Given a PUT request to `/api/v1/portfolios/{id}` is received for a non-existent `{id}`
    - When the API does not find the portfolio
    - Then the API responds `404 Not Found` and returns an error payload.

---

### TS-PR001 -- Create a Profile
As a frontend developer, I want to create a new Profile through the API so that I can add profiles to the system as a feature in my application.

Acceptance criteria:
- Scenario: Successful create
    - Given a POST request to `/api/v1/profiles` is received with a request body containing the create-profile attributes: description, image, profileId, portfolioId, groupProjectIds.
    - When the API validates and persists the profile
    - Then the API responds with `201 Created` and returns the created profile with attributes: id (Int), description(String), image(String), profileId(Int), portfolioId(Int), groupProjectIds(Int[]).
- Scenario: Validation error
    - Given a POST request to `/api/v1/profiles` is received with missing or invalid create-profile attributes (e.g., empty description or image)
    - When the API validates the request and detects validation errors
    - Then the API responds with `400 Bad Request` and returns an error payload describing validation errors.

---

### TS-PR002 -- Get a Profile by id
As a frontend developer, I want to fetch a profile by its `{id}` through the API, so that I can show profile information as a feature in my application.

Acceptance criteria:
- Scenario: Found
    - Given a GET request to `/api/v1/profiles/{id}` is received
    - When the API finds the profile
    - Then the API responds `200 OK` and returns the profile with attributes: id (Int), description(String), image(String), profileId(Int), portfolioId(Int), groupProjectIds(Int[]).
- Scenario: Not found
    - Given a GET request to `/api/v1/profiles/{id}` is received for a non-existent `{id}`
    - When the API does not find the profile
    - Then the API responds `404 Not Found` and returns an error payload.

---

### TS-PR003 -- Get all Profiles
As a frontend developer, I want to list all profiles through the API so that I can show them in a catalogue as a feature in my application.

Acceptance criteria:
- Scenario: profiles exist
    - Given a GET request to `/api/v1/profiles` is received
    - When the API finds one or more profiles
    - Then the API responds `200 OK` and returns a list where each item contains the profile attributes: id (Int), description(String), image(String), profileId(Int), portfolioId(Int), groupProjectIds(Int[]).
- Scenario: No profiles found
    - Given a GET request to `/api/v1/profiles` is received and there are no profiles in the system
    - When the API searches for profiles and finds none
    - Then the API responds `404 Not Found` (per current controller behavior) and returns an appropriate error payload.

---

### TS-PR004 -- Update Profile by id and updated Profile
As a frontend developer, I want to update a profile by its `{id}` through the API, so that I can update profile information as a feature in my application.

Acceptance criteria:
- Scenario: Found
    - Given a PUT request to `/api/v1/profiles/{id}` is received with a request body containing the updated-profile attributes: description, image, profileId, portfolioId, groupProjectIds.
    - When the API finds the profile and update it.
    - Then the API responds `200 OK` and returns the profile with attributes: id (Int), description(String), image(String), profileId(Int), portfolioId(Int), groupProjectIds(Int[]).
- Scenario: Not found
    - Given a PUT request to `/api/v1/profiles/{id}` is received for a non-existent `{id}`
    - When the API does not find the profile
    - Then the API responds `404 Not Found` and returns an error payload.
- Scenario: Validation error
    - Given a PUT request to `/api/v1/profiles` is received with missing or invalid create-profile attributes (e.g., description email or portfolioId)
    - When the API validates the request and detects validation errors
    - Then the API responds with `400 Bad Request` and returns an error payload describing validation errors.

---

### TS-RE001 -- Create a Review
As a frontend developer, I want to create a new Review through the API so that I can add reviews to the system as a feature in my application.

Acceptance criteria:
- Scenario: Successful create
    - Given a POST request to `/api/v1/reviews` is received with a request body containing the create-review attributes: userId, projectId, comment, rating.
    - When the API validates and persists the review
    - Then the API responds with `201 Created` and returns the created review with attributes: id (Int), userId(Int), projectId(Int), comment(String), rating(Int), creationDate(Date).
- Scenario: Validation error
    - Given a POST request to `/api/v1/reviews` is received with missing or invalid create-review attributes (e.g., empty userId or comment)
    - When the API validates the request and detects validation errors
    - Then the API responds with `400 Bad Request` and returns an error payload describing validation errors.

---

### TS-RE002 -- Get a Review by id
As a frontend developer, I want to fetch a review by its `{id}` through the API, so that I can show review information as a feature in my application.

Acceptance criteria:
- Scenario: Found
    - Given a GET request to `/api/v1/reviews/{id}` is received
    - When the API finds the review
    - Then the API responds `200 OK` and returns the review with attributes: id (Int), userId(Int), projectId(Int), comment(String), rating(Int), creationDate(Date).
- Scenario: Not found
    - Given a GET request to `/api/v1/reviews/{id}` is received for a non-existent `{id}`
    - When the API does not find the review
    - Then the API responds `404 Not Found` and returns an error payload.

---

### TS-RE003 -- Get all Reviews
As a frontend developer, I want to list all reviews through the API so that I can show them in a catalogue as a feature in my application.

Acceptance criteria:
- Scenario: reviews exist
    - Given a GET request to `/api/v1/reviews` is received
    - When the API finds one or more reviews
    - Then the API responds `200 OK` and returns a list where each item contains the review attributes: id (Int), userId(Int), projectId(Int), comment(String), rating(Int), creationDate(Date).
- Scenario: No reviews found
    - Given a GET request to `/api/v1/reviews` is received and there are no reviews in the system
    - When the API searches for reviews and finds none
    - Then the API responds `404 Not Found` (per current controller behavior) and returns an appropriate error payload.

---

### TS-PU001 -- Create a Publication
As a frontend developer, I want to create a new Publication through the API so that I can add publications to the system as a feature in my application.

Acceptance criteria:
- Scenario: Successful create
    - Given a POST request to `/api/v1/publications` is received with a request body containing the create-publication attributes: userId, title, comment, image.
    - When the API validates and persists the publication
    - Then the API responds with `201 Created` and returns the created publication with attributes: id (Int), userId(Int), title(String), comment(String | Null), image(String | Null), creationDate(Date).
- Scenario: Validation error
    - Given a POST request to `/api/v1/publications` is received with missing or invalid create-publication attributes (e.g., empty userId or title)
    - When the API validates the request and detects validation errors
    - Then the API responds with `400 Bad Request` and returns an error payload describing validation errors.

---

### TS-PU002 -- Get a Publication by id
As a frontend developer, I want to fetch a publication by its `{id}` through the API, so that I can show publication information as a feature in my application.

Acceptance criteria:
- Scenario: Found
    - Given a GET request to `/api/v1/publications/{id}` is received
    - When the API finds the publication
    - Then the API responds `200 OK` and returns the publication with attributes: id (Int), userId(Int), title(String), comment(String | Null), image(String | Null), creationDate(Date).
- Scenario: Not found
    - Given a GET request to `/api/v1/publications/{id}` is received for a non-existent `{id}`
    - When the API does not find the publication
    - Then the API responds `404 Not Found` and returns an error payload.

---

### TS-PU003 -- Get all Publications
As a frontend developer, I want to list all publications through the API so that I can show them in a catalogue as a feature in my application.

Acceptance criteria:
- Scenario: publications exist
    - Given a GET request to `/api/v1/publications` is received
    - When the API finds one or more publications
    - Then the API responds `200 OK` and returns a list where each item contains the publication attributes: id (Int), userId(Int), title(String), comment(String | Null), image(String | Null), creationDate(Date).
- Scenario: No publications found
    - Given a GET request to `/api/v1/publications` is received and there are no publications in the system
    - When the API searches for publications and finds none
    - Then the API responds `404 Not Found` (per current controller behavior) and returns an appropriate error payload.

---

### TS-AN001 -- Create an Answer
As a frontend developer, I want to create a new Answer through the API so that I can add answers to the system as a feature in my application.

Acceptance criteria:
- Scenario: Successful create
    - Given a POST request to `/api/v1/answers` is received with a request body containing the create-answer attributes: userId, publicationId, comment.
    - When the API validates and persists the answer
    - Then the API responds with `201 Created` and returns the created answer with attributes: id (Int), userId(Int), publicationId(Int), comment(String), creationDate(Date).
- Scenario: Validation error
    - Given a POST request to `/api/v1/answers` is received with missing or invalid create-answer attributes (e.g., empty userId or title)
    - When the API validates the request and detects validation errors
    - Then the API responds with `400 Bad Request` and returns an error payload describing validation errors.

---

### TS-AN002 -- Get an Answer by id
As a frontend developer, I want to fetch an answer by its `{id}` through the API, so that I can show answer information as a feature in my application.

Acceptance criteria:
- Scenario: Found
    - Given a GET request to `/api/v1/answers/{id}` is received
    - When the API finds the answer
    - Then the API responds `200 OK` and returns the answer with attributes: id (Int), userId(Int), publicationId(Int), comment(String), creationDate(Date).
- Scenario: Not found
    - Given a GET request to `/api/v1/answers/{id}` is received for a non-existent `{id}`
    - When the API does not find the answer
    - Then the API responds `404 Not Found` and returns an error payload.

---

### TS-AN003 -- Get all Answers
As a frontend developer, I want to list all answers through the API so that I can show them in a catalogue as a feature in my application.

Acceptance criteria:
- Scenario: answers exist
    - Given a GET request to `/api/v1/answers` is received
    - When the API finds one or more answers
    - Then the API responds `200 OK` and returns a list where each item contains the answer attributes: id (Int), userId(Int), publicationId(Int), comment(String), creationDate(Date).
- Scenario: No answers found
    - Given a GET request to `/api/v1/answers` is received and there are no answers in the system
    - When the API searches for answers and finds none
    - Then the API responds `404 Not Found` (per current controller behavior) and returns an appropriate error payload.

---
