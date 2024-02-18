import sqlite3

class Employee:
    def __init__(self, username, password, department=None):
        self.username = username
        self.password = password
        self.department = department
        self.connection = sqlite3.connect('database.db')
        self.cursor = self.connection.cursor()
        self.save_user()

    def __del__(self):
        self.cursor.close()
        self.connection.close();

    def create_users_table(self):
        self.cursor.execute('''CREATE TABLE IF NOT EXISTS users (
                                id INT PRIMARY KEY AUTO INC,
                                username TEXT,
                                password TEXT,
                                department_id INTEGER,
                                FOREIGN KEY (department_id) REFERENCES departments(id)
                                ON DELETE SET NULL)''')
        self.connection.commit()

    def save_user(self):
        self.cursor.execute("INSERT OR REPLACE INTO users (username, password, department_id) VALUES (?, ?, ?)",
                            (self.username, self.password, self.department.id if self.department else None))
        self.connection.commit()
    
    def remove_user(self):
        self.cursor.execute("DELETE FROM users WHERE username = ?", (self.username,))
        self.connection.commit()

    def change_password(self, new_password):
        self.password = new_password
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