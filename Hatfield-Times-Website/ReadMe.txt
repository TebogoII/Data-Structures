Once youre on the homepage
click PA3
View Articles
click Login under the menu
click sign in to create account

Validation
Validation is neccesary in order to have a secure system whith database values that are correctly
formatted and entered such as the @ in emails. It is better to have Caps Digits and small letters 
in a password to make it harder to guess and attack through brute force, and the 8 character limit
ensures that the number of combinations are almost impossible to process via brute force.

Hashing
I decided to used SHA256 Hashing Technique because it is very secure, 
and the hash values will always be the same depending on the input
the chances of collision are highly improbable because of the way the algorithm works

API Key
The API Key was created by hashing the username of the user because it is unique 
as it's a primary key and it will allow users to have a unique API Key which wont easily 
be exploited by someone who doesnt have access to this key.

Unimplemented 
Logging in to request API Data, currently the API loads immediately on the API link
Online database function because my MySQL account has not been properly initialized and was unable to log in