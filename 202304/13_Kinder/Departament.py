import sqlite3

class Department:
    def __init__(self, id, name):
        self.id = id
        self.name = name
        self.users = []
        self.connection = sqlite3.connect('database.db')
        self.cursor = self.connection.cursor()
        self.create_departments_table()

    def create_departments_table(self):
        self.cursor.execute('''CREATE TABLE IF NOT EXISTS departments (
                                id INTEGER PRIMARY KEY AUTOINCREMENT,
                                name TEXT)''')
        self.connection.commit()

    def save_department(self):
        self.cursor.execute("INSERT INTO departments (name) VALUES (?)", (self.name,))
        self.connection.commit()

    def remove_department(self):
        self.cursor.execute("DELETE FROM  departments WHERE id = ?", (self.id,))
        self.connection.commit()

    def update_name(self, new_name):
        self.name = new_name
        self.save_department()

    def add_user(self, user):
        self.users.append(user)
        user.department = self
        user.save_user()

    def remove_user(self, user):
        self.users.remove(user)
        user.department = None
        user.save_user()

    def get_users(self):
        self.cursor.execute("SELECT * FROM users WHERE department_id = ?", (self.id,))
        users_db = self.cursor.fetchall()
        self.users = []
        for user in users_db:
            username = user[0]
            password = user[1]
            full_name = user[2]
            email = user[3]
            user_obj = User(username, password, full_name, email)
            self.users.append(user_obj)

    def get_user(self, username):
        user = None
        self.cursor.execute("SELECT * FROM users WHERE department_id = ? AND username = ?",
                          (self.id, username))
        user_db = self.cursor.fetchone()
        if user_db:
            username = user_db[0]
            password = user_db[1]
            full_name = user_db[2]
            email = user_db[3]
            user = User(username, password, full_name, email)
        return user