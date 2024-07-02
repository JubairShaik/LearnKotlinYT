code import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "exploreBrands") {
        composable("exploreBrands") { ExploreBrandsScreen(navController) }
        // Add other composable routes here
    }
}

@Composable
fun ExploreBrandsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Explore Brands") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(imageVector = androidx.compose.material.icons.Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(imageVector = androidx.compose.material.icons.Icons.Filled.ShoppingCart, contentDescription = "Shop") },
                    label = { Text("Shop") },
                    selected = false,
                    onClick = {
                        navController.navigate("shop")
                    }
                )
                BottomNavigationItem(
                    icon = { Icon(imageVector = androidx.compose.material.icons.Icons.Filled.ShoppingBag, contentDescription = "Orders") },
                    label = { Text("Orders") },
                    selected = false,
                    onClick = {
                        navController.navigate("orders")
                    }
                )
                BottomNavigationItem(
                    icon = { Icon(imageVector = androidx.compose.material.icons.Icons.Filled.CreditCard, contentDescription = "Cards") },
                    label = { Text("Cards") },
                    selected = false,
                    onClick = {
                        navController.navigate("cards")
                    }
                )
                BottomNavigationItem(
                    icon = { Icon(imageVector = androidx.compose.material.icons.Icons.Filled.Person, contentDescription = "Account") },
                    label = { Text("Account") },
                    selected = false,
                    onClick = {
                        navController.navigate("account")
                    }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            // Tab Buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { /* Handle click */ },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Text("All", color = Color.White)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { /* Handle click */ },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("New", color = Color.Black)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { /* Handle click */ },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("Popular", color = Color.Black)
                }
            }

            // Brand Cards
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BrandCard(
                        image = painterResource(id = R.drawable.ic_apple),
                        brandName = "Apple"
                    )
                    BrandCard(
                        image = painterResource(id = R.drawable.ic_zara),
                        brandName = "Zara"
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BrandCard(
                        image = painterResource(id = R.drawable.ic_nike),
                        brandName = "Apple"
                    )
                    BrandCard(
                        image = painterResource(id = R.drawable.ic_levi),
                        brandName = "Zara"
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BrandCard(
                        image = painterResource(id = R.drawable.ic_samsung),
                        brandName = "Samsung"
                    )
                    BrandCard(
                        image = painterResource(id = R.drawable.ic_versace),
                        brandName = "Versace"
                    )
                }
            }
        }
    }
}

@Composable
fun BrandCard(image: Painter, brandName: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        onClick = { /* Handle click */ }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(painter = image, contentDescription = null, modifier = Modifier.size(64.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(brandName, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExploreBrandsScreen(navController = rememberNavController())
}


Step-by-Step Guide for Kotlin Android Development
 
Step 1: Setup and Basics
Setup Java JDK for your OS

Install the Java Development Kit (JDK) on your operating system.
Ensure that your development environment is properly configured.
Basics of Kotlin

Understand the basic syntax of Kotlin.
Learn about variables (val and var), data types, and basic operations.
Practice using the print and println functions for output.
Primitive (Built-in) Data Types

Learn about Kotlin's primitive data types (e.g., Int, Double, Char, Boolean).
Step 2: Control Flow and Collections
Control Flow Statements

Learn about if-else statements.
Understand when statements (similar to switch in Java).
Practice loops: for, while, do-while, and labeled loops with break and continue.
Kotlin Collections

Learn about List and MutableList.
Understand Set and MutableSet.
Explore Map and MutableMap.
Predicates and Collection Functions

Learn to use predicates like all, any, count, and find.
Practice collection functions such as filter and map.
Step 3: Object-Oriented Programming (OOP) Concepts
Common OOP Concepts

Understand classes and objects.
Learn about primary and secondary constructors.
Study inheritance, polymorphism, and abstraction.
Explore access modifiers: private, protected, public.
Advanced OOP Concepts

Understand sealed classes.
Learn about companion objects and their use.
Study the concept of data classes.
Step 4: Functions and Functional Programming
Functions in Kotlin

Learn about function expressions.
Understand named parameters, default parameters, and varargs.
Practice lambdas and higher-order functions.
Explore extension functions.
Scope Functions

Learn about apply, also, let, with, and run.
Step 5: Advanced Kotlin Features
Java Interoperability

Understand how Kotlin interacts with Java code.
Practice calling Java methods from Kotlin and vice versa.
Kotlin Coroutines

Learn the basics of Kotlin coroutines for asynchronous programming.
Exception Handling

Understand Kotlin's exception handling mechanisms.
Step 6: Null Safety and Smart Casting
Null Safety

Learn about null safety in Kotlin using the safe call operator (?.), Elvis operator (?:), and non-null assertion operator (!!).
Understand the lateinit keyword for variables.
Explore the concept of backing fields in getters and setters.
Type Checking and Smart Casting

Understand how Kotlin handles type checking and smart casting.
Step 7: Final Touches
Other Commonly Used Concepts

Study unary and binary operators, overloading, and overriding.
Learn about object expressions and declarations.
Explore the use of enum classes.
Kotlin Crash Course for Android

Dive into Android-specific Kotlin practices.
Follow tutorials and build small projects to solidify your understanding.
Practice and Projects
Start with simple Android apps to apply your knowledge.
Gradually build more complex apps as you become comfortable with the language and concepts.
Resources
Official Kotlin Documentation
Android Developer Guides
Online tutorials and courses (Paid or Free)
Books on Kotlin and Android Development












