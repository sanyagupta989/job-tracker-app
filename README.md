# Job Tracker App

## Overview

This is a Spring Boot-based REST API for managing job applications.
It allows users to store, filter, sort, and paginate job records efficiently.

---

## Features

- CRUD operations for jobs
- Filtering by:
  - Company
  - Role
  - Status

- Sorting:
  - Ascending / Descending
  - Based on any field (e.g., company, status)

- Pagination:
  - Page number & size-based data fetching

---

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

---

## API Endpoints

### Get Jobs (Filter + Sort + Pagination)

GET /api/v1/job/sort/filter/paging

#### Query Parameters:

- `company` (optional)
- `role` (optional)
- `status` (optional)
- `page` (default: 0)
- `size` (default: 5)
- `sortBy` (default: jobId)
- `direction` (asc / desc)

#### Example:

GET /api/v1/job/sort/filter/paging?company=Amazon&status=Applied&page=0&size=5&sortBy=company&direction=desc

---

## How It Works

- Filtering is handled dynamically using Spring Data JPA method naming
- Sorting is applied using `Sort`
- Pagination is handled using `Pageable`
- All features are combined into a single API endpoint

---

## Getting Started

### 1. Clone the repository

git clone https://github.com/your-username/job-tracker-api.git

### 2. Navigate to project

cd job-tracker-api

### 3. Run the application

./mvnw spring-boot:run

---

## Future Improvements

- Add JWT Authentication
- Add user login & signup
- Improve filtering using Specifications
- Add frontend UI

---

## Author

Sanya Gupta
