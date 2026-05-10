# 🤖 AI Interview Question Generator

A modern web application that generates tailored interview questions for any job role using AI. Built with React frontend and Spring Boot backend, powered by Google's Gemini AI.

![AI Interview Question Generator](frontend/src/assets/melo.png)

## ✨ Features

- **AI-Powered Generation** - Uses Google Gemini AI to create relevant interview questions
- **Job-Specific Questions** - Tailored questions based on job title input
-

## 🚀 Live Demo

- **Frontend**: [Deployed on Netlify/Vercel] (Add your URL here)
- **Backend API**: [Deployed on Render] (Add your URL here)

## 🛠️ Tech Stack

### Frontend
- **React 19** - Modern React with hooks
- **CSS Variables** - Maintainable styling system
- **Responsive Design** - Mobile-first approach
- **Modern JavaScript** - ES6+ features

### Backend
- **Spring Boot 3** - Java web framework
- **Maven** - Dependency management
- **Google Gemini AI** - AI question generation
- **Docker** - Containerization for deployment

### Deployment
- **Frontend**: Netlify/Vercel
- **Backend**: Render (Docker container)
- **Version Control**: Git/GitHub

## 📁 Project Structure

```
Melo-Associates/
├── frontend/                    # React application
│   ├── src/
│   │   ├── components/         # React components
│   │   │   ├── InterviewGenerator.jsx
│   │   │   └── InterviewGenerator.css
│   │   ├── assets/            # Images and static files
│   │   ├── App.jsx            # Main app component
│   │   ├── App.css            # App-level styles
│   │   └── index.css          # Global styles & CSS variables
│   ├── public/                # Static assets
│   └── package.json           # Dependencies
│
├── backend/                    # Spring Boot API
│   ├── src/main/java/com/melo/questiongenerator/
│   │   ├── controller/        # REST controllers
│   │   ├── service/           # Business logic
│   │   ├── dto/              # Data transfer objects
│   │   └── QuestionGeneratorApplication.java
│   ├── src/main/resources/
│   │   └── application.properties
│   ├── Dockerfile            # Docker configuration
│   └── pom.xml              # Maven dependencies
│
└── README.md                 # Project documentation
```

## 🚦 Getting Started

### Prerequisites
- **Node.js** 16+ and npm
- **Java** 17+ and Maven
- **Google Gemini API Key**

### 1. Clone Repository
```bash
git clone https://github.com/yourusername/Melo-Associates.git
cd Melo-Associates
```

### 2. Backend Setup
```bash
cd backend

# Create .env file
echo "GEMINI_API_KEY=yapi_key_here" > .env

# Install dependencies and run
mvn clean install
mvn spring-boot:run
```

Backend will run on `http://localhost:8080`

### 3. Frontend Setup
```bash
cd frontend

# Install dependencies
npm install

# Start development server
npm start
```

Frontend will run on `http://localhost:3000`

### 4. Get Gemini API Key
1. Go to [Google AI Studio](https://makersuite.google.com/app/apikey)
2. Create a new API key
3. Add it to your `.env` file

## 🐳 Docker Deployment

### Build and Run Backend
```bash
cd backend

# Build Docker image
docker build -t question-generator .

# Run container
docker run -p 8080:8080 -e GEMINI_API_KEY=your_key question-generator
```





## 📱 API Endpoints

### Generate Questions
```http
POST /api/generate-questions
Content-Type: application/json

{
  "jobTitle": "Senior Software Engineer"
}
```

**Response:**
```json
{
  "questions": "1. What is your experience with...\n2. How do you handle..."
}
```

## 🎯 Features in Detail

### AI Question Generation
- Powered by Google Gemini AI
- Generates role-specific questions
- Considers industry best practices
- Provides comprehensive question sets


## 🚀 Deployment

### Backend (Render)
1. Push code to GitHub
2. Connect repository to Render
3. Set root directory to `backend`
4. Add environment variables
5. Deploy automatically

### Frontend (Netlify/Vercel)
1. Connect repository
2. Set build directory to `frontend`
3. Configure build commands
4. Deploy automatically


## 🙏 Acknowledgments

- Google Gemini AI for question generation
- React team for the amazing framework
- Spring Boot for the robust backend framework
- The open-source community

---

⭐ **Star this repository if you found it helpful!**