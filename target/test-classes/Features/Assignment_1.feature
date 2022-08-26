Feature:  SwagLabs Buy a product

Scenario: Validate to login


Given: Launch the URL
|https://www.saucedemo.com/|
Then : Enter the credentials username and password
|standard_user|secret_sauce|
And : Verify that user loggedinSuccessfully
Then : Sort the Product with the highest price
Then : Select the first Product and Verify its detail
Then : Select the product and checkout the order
Then : Enter detail for checkOut
|Nishi|Srivastava|201304|
Then : verify Order is Placed
|THANK YOU FOR YOUR ORDER|


