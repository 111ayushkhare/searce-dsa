import sqlite3

# Creating a connection object which represents the databse
connection = sqlite3.connect('example.db')

# Creating a cursor object which has methods to operate on database
cursor = connection.cursor()

# Creating a table in the database
# Also handling the exception if the named table already exixts
try:
    cursor.execute("CREATE TABLE Student (ID int UNIQUE, Name text, Year int, Address text)")
except sqlite3.OperationalError as error:
    print(error)


# Inserting values to the created table
# Also handling the UNIQUE constraint exception 
try:
    cursor.execute("INSERT INTO Student VALUES (01, 'AKASH', 4, 'KOTMA')")
    cursor.execute("INSERT INTO Student VALUES (02, 'ANKIT', 4, 'JAUNPUR')")
    cursor.execute("INSERT INTO Student VALUES (03, 'AYUSH', 4, 'SHAHDOL')")
    cursor.execute("INSERT INTO Student VALUES (04, 'SHREYASH', 4, 'INDORE')")
    cursor.execute("INSERT INTO Student VALUES (05, 'SHUBHAM', 4, 'PATNA')")
    cursor.execute("INSERT INTO Student VALUES (06, 'SHIKHAR', 4, 'ANUPPUR')")
except sqlite3.IntegrityError as error:
    print(error)

# Saving the changes
connection.commit()


# Printing the inserted data
print('Inserted-1')
for row in cursor.execute('SELECT * FROM Student'):
    print(row)

cursor.execute("UPDATE Student SET Address='DHAR' WHERE ID = 04")


# Printing the update data
print('Updated-1')
for row in cursor.execute('SELECT * FROM Student'):
    print(row)

# Saving the changes
connection.commit()


cursor.execute("DELETE FROM Student WHERE ID=06")

# Printing the data after deletion
print('Deleted-1')
for row in cursor.execute('SELECT * FROM Student'):
    print(row)

# Saving the changes
connection.commit()


# Closing the connection object
connection.close()