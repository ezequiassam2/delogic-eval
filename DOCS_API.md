# API Documentation

## Category API

### Get All Category IDs

**Request:**
```
GET /categories
```
**Parameters:**
- `page` (optional, default: `${default.page}`)
- `size` (optional, default: `${default.size}`)
- `includeUrls` (optional, default: `false`)

**Response:**
```json
[
  1,
  2,
  3
]
```

### Get Category by ID

**Request:**
```
GET /categories/{id}
```
**Path Parameters:**
- `id` (required)

**Response:**
```json
{
  "categoryId": 1,
  "group": "Group Name",
  "name": "Category Name",
  "description": "Category Description"
}
```

## Date API

### Get All Date IDs

**Request:**
```
GET /dates
```
**Parameters:**
- `page` (optional, default: `${default.page}`)
- `size` (optional, default: `${default.size}`)
- `includeUrls` (optional, default: `false`)

**Response:**
```json
[
    1,
    2,
    3
]
```

### Get Date by ID

**Request:**
```
GET /dates/{id}
```
**Path Parameters:**
- `id` (required)

**Response:**
```json
{
    "id": 1,
    "calendarDate": "2023-10-10",
    "day": "Tuesday",
    "week": 41,
    "month": "October",
    "quarter": 4,
    "year": 2023,
    "holidayFlag": false
}
```

## Event API

### Get All Event IDs

**Request:**
```
GET /events
```
**Parameters:**
- `page` (optional, default: `${default.page}`)
- `size` (optional, default: `${default.size}`)
- `includeUrls` (optional, default: `false`)

**Response:**
```json
[
    1,
    2,
    3
]
```

### Get Event by ID

**Request:**
```
GET /events/{id}
```
**Path Parameters:**
- `id` (required)

**Response:**
```json
{
    "id": 1,
    "name": "Event Name",
    "startTime": "2023-10-10T20:00:00",
    "venue": {
        "id": 1,
        "name": "Venue Name",
        "city": "City Name",
        "state": "State Name",
        "seatingCapacity": 1000
    },
    "category": {
        "categoryId": 1,
        "group": "Group Name",
        "name": "Category Name",
        "description": "Category Description"
    },
    "date": {
        "id": 1,
        "calendarDate": "2023-10-10",
        "day": "Tuesday",
        "week": 41,
        "month": "October",
        "quarter": 4,
        "year": 2023,
        "holidayFlag": false
    }
}
```

## Listing API

### Get All Listing IDs

**Request:**
```
GET /listings
```
**Parameters:**
- `page` (optional, default: `${default.page}`)
- `size` (optional, default: `${default.size}`)
- `includeUrls` (optional, default: `false`)

**Response:**
```json
[
    1,
    2,
    3
]
```

### Get Listing by ID

**Request:**
```
GET /listings/{id}
```
**Path Parameters:**
- `id` (required)

**Response:**
```json
{
    "id": 1,
    "numberOfTickets": 2,
    "pricePerTicket": 50.00,
    "totalPrice": 100.00,
    "timestamp": "2023-10-10T20:00:00",
    "seller": {
        "id": 1,
        "username": "seller1",
        "firstName": "First",
        "lastName": "Last",
        "city": "City",
        "state": "State",
        "email": "seller1@example.com",
        "phone": "123-456-7890",
        "sports": true,
        "theatre": false,
        "concerts": true,
        "jazz": false,
        "classical": false,
        "opera": false,
        "rock": true,
        "vegas": false,
        "broadway": false,
        "musicals": false
    },
    "event": {
        "id": 1,
        "name": "Event Name",
        "startTime": "2023-10-10T20:00:00",
        "venue": {
            "id": 1,
            "name": "Venue Name",
            "city": "City Name",
            "state": "State Name",
            "seatingCapacity": 1000
        },
        "category": {
            "categoryId": 1,
            "group": "Group Name",
            "name": "Category Name",
            "description": "Category Description"
        },
        "date": {
            "id": 1,
            "calendarDate": "2023-10-10",
            "day": "Tuesday",
            "week": 41,
            "month": "October",
            "quarter": 4,
            "year": 2023,
            "holidayFlag": false
        }
    },
    "date": {
        "id": 1,
        "calendarDate": "2023-10-10",
        "day": "Tuesday",
        "week": 41,
        "month": "October",
        "quarter": 4,
        "year": 2023,
        "holidayFlag": false
    }
}
```

## Sale API

### Get All Sale IDs

**Request:**
```
GET /sales
```
**Parameters:**
- `page` (optional, default: `${default.page}`)
- `size` (optional, default: `${default.size}`)
- `includeUrls` (optional, default: `false`)

**Response:**
```json
[
    1,
    2,
    3
]
```

### Get Sale by ID

**Request:**
```
GET /sales/{id}
```
**Path Parameters:**
- `id` (required)

**Response:**
```json
{
    "id": 1,
    "quantitySold": 2,
    "pricePaid": 100.00,
    "commissionAmount": 10.00,
    "timestamp": "2023-10-10T20:00:00",
    "listing": {
        "id": 1,
        "numberOfTickets": 2,
        "pricePerTicket": 50.00,
        "totalPrice": 100.00,
        "timestamp": "2023-10-10T20:00:00",
        "seller": {
            "id": 1,
            "username": "seller1",
            "firstName": "First",
            "lastName": "Last",
            "city": "City",
            "state": "State",
            "email": "seller1@example.com",
            "phone": "123-456-7890",
            "sports": true,
            "theatre": false,
            "concerts": true,
            "jazz": false,
            "classical": false,
            "opera": false,
            "rock": true,
            "vegas": false,
            "broadway": false,
            "musicals": false
        },
        "event": {
            "id": 1,
            "name": "Event Name",
            "startTime": "2023-10-10T20:00:00",
            "venue": {
                "id": 1,
                "name": "Venue Name",
                "city": "City Name",
                "state": "State Name",
                "seatingCapacity": 1000
            },
            "category": {
                "categoryId": 1,
                "group": "Group Name",
                "name": "Category Name",
                "description": "Category Description"
            },
            "date": {
                "id": 1,
                "calendarDate": "2023-10-10",
                "day": "Tuesday",
                "week": 41,
                "month": "October",
                "quarter": 4,
                "year": 2023,
                "holidayFlag": false
            }
        },
        "date": {
            "id": 1,
            "calendarDate": "2023-10-10",
            "day": "Tuesday",
            "week": 41,
            "month": "October",
            "quarter": 4,
            "year": 2023,
            "holidayFlag": false
        }
    },
    "seller": {
        "id": 1,
        "username": "seller1",
        "firstName": "First",
        "lastName": "Last",
        "city": "City",
        "state": "State",
        "email": "seller1@example.com",
        "phone": "123-456-7890",
        "sports": true,
        "theatre": false,
        "concerts": true,
        "jazz": false,
        "classical": false,
        "opera": false,
        "rock": true,
        "vegas": false,
        "broadway": false,
        "musicals": false
    },
    "buyer": {
        "id": 2,
        "username": "buyer1",
        "firstName": "First",
        "lastName": "Last",
        "city": "City",
        "state": "State",
        "email": "buyer1@example.com",
        "phone": "123-456-7890",
        "sports": true,
        "theatre": false,
        "concerts": true,
        "jazz": false,
        "classical": false,
        "opera": false,
        "rock": true,
        "vegas": false,
        "broadway": false,
        "musicals": false
    },
    "event": {
        "id": 1,
        "name": "Event Name",
        "startTime": "2023-10-10T20:00:00",
        "venue": {
            "id": 1,
            "name": "Venue Name",
            "city": "City Name",
            "state": "State Name",
            "seatingCapacity": 1000
        },
        "category": {
            "categoryId": 1,
            "group": "Group Name",
            "name": "Category Name",
            "description": "Category Description"
        },
        "date": {
            "id": 1,
            "calendarDate": "2023-10-10",
            "day": "Tuesday",
            "week": 41,
            "month": "October",
            "quarter": 4,
            "year": 2023,
            "holidayFlag": false
        }
    },
    "date": {
        "id": 1,
        "calendarDate": "2023-10-10",
        "day": "Tuesday",
        "week": 41,
        "month": "October",
        "quarter": 4,
        "year": 2023,
        "holidayFlag": false
    }
}
```

## User API

### Get All User IDs or URLs

**Request:**
```
GET /users
```
**Parameters:**
- `page` (optional, default: `${default.page}`)
- `size` (optional, default: `${default.size}`)
- `includeUrls` (optional, default: `false`)

**Response:**
```json
[
    1,
    2,
    3
]
```

### Get User by ID

**Request:**
```
GET /users/{id}
```
**Path Parameters:**
- `id` (required)

**Response:**
```json
{
    "id": 1,
    "username": "user1",
    "firstName": "First",
    "lastName": "Last",
    "city": "City",
    "state": "State",
    "email": "user1@example.com",
    "phone": "123-456-7890",
    "sports": true,
    "theatre": false,
    "concerts": true,
    "jazz": false,
    "classical": false,
    "opera": false,
    "rock": true,
    "vegas": false,
    "broadway": false,
    "musicals": false
}
```

## Venue API

### Get All Venue IDs

**Request:**
```
GET /venues
```
**Parameters:**
- `page` (optional, default: `${default.page}`)
- `size` (optional, default: `${default.size}`)
- `includeUrls` (optional, default: `false`)

**Response:**
```json
[
    1,
    2,
    3
]
```

### Get Venue by ID

**Request:**
```
GET /venues/{id}
```
**Path Parameters:**
- `id` (required)

**Response:**
```json
{
  "id": 1,
  "name": "Venue Name",
  "city": "City Name",
  "state": "State Name",
  "seatingCapacity": 1000
}
```