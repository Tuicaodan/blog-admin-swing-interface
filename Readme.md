**Introduction**:

The individual project is to create an administrative user interface. You could log in and log out. If you are an admin, you will get the registered user report from the database, and it will display in a JTable. You can also delete any user besides yourself.

**How to use:**

```
Admin User:
Username: enigmaCracker
Password: password

Non-admin User:
Username: datacomDude
Password: pw123
```

You don't need to run the SQL. The database has been initialized. 
If you use an admin user account to log in, You will receive the full user report from the database, and it will show on the table. If you use a non-admin user account to log in, you can log in. But you will be logged out once the server finds out you are not an admin user.
Once the user report shows on the table, you can click on the user you want to delete. Then you could click the delete user button to delete the selected user from the database. The "Delete user" function is design to wipe all user information in the database. But will keep userID and username as placeholders.

**Something to notice**

If you clicked on the juncture of the rows in the table views, The row index will not be read by the program even the row is highlighted. Therefore, when you find the "Delete user" is not functional, you need to re-select the user and delete it again. I believe this is just a glitch for getSelectedRow in JTable.

