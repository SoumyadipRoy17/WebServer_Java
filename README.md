# Java Web Server Simulation

This project simulates a basic Java web server using three different threading models:

- **Single-threaded**
- **Multi-threaded (per client)**
- **Thread Pool**

Each implementation demonstrates how a Java server handles client connections differently using core Java networking and concurrency APIs.

---

## 📁 Folder Structure

java-webserver-simulation/ │ 
     ├── SingleThreaded/ │ 
         └── Server.java │
         └── Client.java │
     ├── Multithreaded/ │ 
         └── Server.java │ 
         └── Client.java │ 
     ├── ThreadPooled/ │ 
         └── Server.java │ 


---

## 🧠 Concepts Covered

### 1. SingleThreaded Server

- Handles one client at a time.
- Blocks all incoming connections while processing one.
- Good for understanding the basics, but not scalable.

### 2. Multithreaded Server

- Creates a new thread for each client connection.
- More scalable than single-threaded, but can cause resource issues with many clients.
- Demonstrates use of Java `Thread` and lambda functions.

### 3. Thread Pooled Server

- Uses a fixed-size thread pool to handle client connections.
- Efficient and scalable.
- Uses `Executors.newFixedThreadPool()` from Java's concurrent API.

---

## 🚀 How to Run

### 🛠 Requirements

- Java 8 or higher
- Terminal or IDE (e.g., IntelliJ, Eclipse, VS Code)

### 🔧 Compile

Navigate to each directory and compile:

```bash
javac Server.java
javac Client.java  # in Client/ folder


▶️ Run
1. Start the Server
For example, in Multithreaded:

bash
cd Multithreaded
java Server
2. Run the Client
In another terminal:

bash
cd Client
java Client
You should see:

pgsql
Hello from server!
You can open multiple client terminals to simulate concurrent connections.

📈 Performance Comparison

Server Type	Concurrency	Resource Usage	Complexity
SingleThreaded	❌	✅ Low	✅ Simple
MultiThreaded	✅	❌ High	⚠️ Moderate
Thread Pooled	✅	✅ Controlled	✅ Scalable
📌 Notes
You can configure ports in the server files (default is 8010).

For accurate testing, use tools like Apache JMeter.

📄 License
This project is open-source and available under the MIT License.
