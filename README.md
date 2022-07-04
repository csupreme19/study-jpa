# Spring Data JPA Study

### 개요

본 프로젝트는 Spring Data JPA를 학습하기 위한 프로젝트입니다.



### ER

```mermaid
erDiagram

    PERSON {
        long id PK
        string account_id FK
        long age
        string phone
        string email
        timestamp created_at
        string created_ip
        timestamp modified_at
        string modified_ip
    }
    
    ACCOUNT {
        string id PK
        string password
        string username
        boolean enabled
        timestamp last_password_modified_at
        timestamp created_at
        string created_ip
        timestamp modified_at
        string modified_ip
    }
    
    POST {
    		long id PK
    		long category_id FK
    		string title
    		string content
    		boolean enabled
    		long view_count
        timestamp created_at
        string created_id FK
        string created_ip
        timestamp modified_at
        string modified_id FK
        string modified_ip
    }

    CATEGORY {
    		long id PK
    		string category_name
    		long parent_id FK
        timestamp created_at
        string created_ip
        timestamp modified_at
        string modified_ip
    }
    
    TAG {
    		long id PK
    		string tag_name
        timestamp created_at
        string created_ip
        timestamp modified_at
        string modified_ip
    }
    
    POST_TAG {
    		long post_id FK
    		long tag_id FK
    }
    
    ITEM {
        long id PK
        string item_name
        string item_number
        long item_price
        boolean enabled
        timestamp created_at
        string created_ip
        timestamp modified_at
        string modified_ip
    }

    PERSON ||--|| ACCOUNT : is
    ACCOUNT ||--|{ POST : uses
    CATEGORY ||--|{ POST : contains
    POST ||--|{ POST_TAG : uses
    TAG ||--|{ POST_TAG : uses
    CATEGORY ||--|{ CATEGORY : contains
```



### 기술 스택

| 기술            | 버전    | 비고                        |
| --------------- | ------- | --------------------------- |
| Java            | 17      | 언어                        |
| Spring Boot     | 2.7.0   | 프레임워크                  |
| Spring Data JPA | 2.7.0   | DB 영속성 프레임워크        |
| Spring DevTools | 2.7.0   | LiveReload 사용 생산성 향상 |
| ModelMapper     | 3.1.0   | Entity, DTO간 변환          |
| H2              | 2.1.212 | 인메모리 DB                 |
| Lombok          | 1.18.24 | 보일러플레이트 줄이기       |



