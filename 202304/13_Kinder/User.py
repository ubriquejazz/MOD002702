import sqlite3

class User:
    def __init__(self, username, password, full_name, email, department=None):
        self.username = username
        self.password = password
        self.full_name = full_name
        self.email = email
        self.department = department
        self.connection = sqlite3.connect('database.db')
        self.cursor = self.connection.cursor()
        self.create_users_table()

    def create_users_table(self):
        self.cursor.execute('''CREATE TABLE IF NOT EXISTS users (
                                username TEXT PRIMARY KEY,
                                password TEXT,
                                full_name TEXT,
                                email TEXT,
                                department_id INTEGER,
                                FOREIGN KEY (department_id) REFERENCES departments(id)
                                ON DELETE SET NULL)''')
        self.connection.commit()

    def save_user(self):
        self.cursor.execute("INSERT OR REPLACE INTO users (username, password, full_name, email, department_id) VALUES (?, ?, ?, ?, ?)",
                            (self.username, self.password, self.full_name, self.email, self.department.id if self.department else None))
        self.connection.commit()
    
    def remove_user(self):
        self.cursor.execute("DELETE FROM users WHERE username = ?", (self.username,))
        self.connection.commit()

    def change_password(self, new_password):
        self.password = new_password
        self.save_user()

    def update_email(self, new_email):
        self.email = new_email
        self.save_user()

    def get_department(self):
        if self.department:
            self.cursor.execute("SELECT * FROM departments WHERE id = ?", (self.department.id,))
            department_db = self.cursor.fetchone()
            if department_db:
                department_name = department_db[1]
                self.department.name = department_name
        return department_name

    def verify_credentials(self):
        self.cursor.execute("SELECT COUNT(*) FROM users WHERE username = ? AND password = ?", (self.username, self.password))
        result = self.cursor.fetchone()
        if result and result[0] > 0:
            return True  # Credentials are correct
        return False  # Credentials are incorrect