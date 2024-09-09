# Library Management System (LMS)

This is a simple Library Management System (LMS) Android application developed using Java and SQLite.

## Features* **User Registration and Login:** Users can register with the system and login with their credentials.
* **Admin Panel:** An admin panel allows administrators to manage books and user accounts.
* **Add Books:** Administrators can add new books to the library, specifying details like title, author, category, and availablestock.
* **View Books:** Users can view the list of available books in the library.(Bugs exists need to be fixed).
* **(Optional) Issue and Return Books:**  (You can add this feature if you plan to implement it)
* **(Optional) Search Functionality:** (You can add this feature if you plan to implement it)

## Technologies Used

* **Programming Language:** Java
* **Database:** SQLite
* **IDE:** Android Studio

## Setup Instructions

1. Clone the repository to your local machine.
2. Open the project in Android Studio.
3. Build and run the application on an emulator orphysical device.

## Database

The application uses an SQLite database to store user and book information.

* **users table:**
    * `sid` (TEXT, primary key): Student ID
    * `sname` (TEXT): Student name
    * `email` (TEXT): Student email
    * `pass` (TEXT): Student password
    * `role` (TEXT): User role (user or admin)
* **booklist table:**
    * `bookid` (TEXT, primary key): Book ID
    * `bookname` (TEXT): Book name
    * `author` (TEXT): Author name
    * `category` (TEXT): Book category
    * `available` (INTEGER): Number of available copies

## Default Admin User

A default admin user is created when the database is first created:

* **ID:** 1
* **Password:** admin

**Note:** For security reasons, it is recommended to change the default admin password or implement a more secure authentication mechanism in a production environment.

## Future Enhancements

* Implement book issue and return functionality.
* Add search functionality for books.
* Improve user interface and user experience.
* Implement user roles andpermissions.

## Contributing

Contributions are welcome! Feel free to submit pull requests for bug fixes, feature enhancements, or other improvements.

## License

This project is licensed under the [MIT License](LICENSE).
