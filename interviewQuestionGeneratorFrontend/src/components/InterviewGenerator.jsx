import { useState } from 'react';
import meloLogo from '../assets/melo.png';
import { API } from '../api';
import './InterviewGenerator.css';

function InterviewGenerator() {
  const [jobTitle, setJobTitle] = useState("");
  const [questions, setQuestions] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");
  const [copied, setCopied] = useState(false);

  async function generateQuestions() {
    if (!jobTitle.trim()) return;
    
    setLoading(true);
    setError("");
    setQuestions("");
    setCopied(false);

    try {
      const response = await fetch(API.GENERATE_QUESTIONS, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ jobTitle }),
      });

      if (!response.ok) {
        throw new Error("Failed to generate questions");
      }

      const data = await response.json();
      setQuestions(data.questions);
    } catch (err) {
      setError("Unable to generate questions. Please check your connection and try again.");
    } finally {
      setLoading(false);
    }
  }

  const handleKeyPress = (e) => {
    if (e.key === 'Enter' && !loading && jobTitle.trim()) {
      generateQuestions();
    }
  };

 
  const formatQuestions = (text) => {
    return text.split('\n').map((line, index) => {
      if (line.trim() === '') return null;
      
      // Check if line is a question (contains '?')
      if (line.includes('?')) {
        return (
          <div key={index} className="question-item">
            <div className="question-number">{line.match(/^\d+/) ? '' : '•'}</div>
            <div className="question-text">{line.replace(/^\d+\.?\s*/, '')}</div>
          </div>
        );
      }
      
      // Section headers or other text
      return (
        <div key={index} className={line.match(/^[A-Z\s]+:/) ? 'section-header' : 'question-text'}>
          {line}
        </div>
      );
    }).filter(Boolean);
  };

  return (
    <div className="interview-generator">
      <header className="header">
        <div className="icon">
          <img src={meloLogo} alt="Melo Logo" className="logo-image" />
        </div>
        <h1>Interview Questions Generator</h1>
        <p className="subtitle">Generate tailored interview questions for your next interview</p>
      </header>

      <div className="input-section">
        <div className="input-group">
          <label htmlFor="jobTitle">Enter Job Title</label>
          <input
            id="jobTitle"
            type="text"
            value={jobTitle}
            onChange={(e) => setJobTitle(e.target.value)}
            onKeyPress={handleKeyPress}
            placeholder="e.g. Customer Success Manager, Software Engineer, e.t.c."
            className={error ? 'error-input' : ''}
            disabled={loading}
          />
        </div>

        <button 
          onClick={generateQuestions} 
          disabled={loading || !jobTitle.trim()}
          className="generate-btn"
        >
          {loading ? (
            <>
              <div className="spinner"></div>
              Generating Questions...
            </>
          ) : (
            <>
            <span>✨</span>
              Generate Questions
            </>
          )}
        </button>
      </div>

      {error && (
        <div className="error-message">
          <span className="error-icon">⚠️</span>
          {error}
        </div>
      )}

      {questions && (
        <div className="results">
          <div className="results-header">
            <h2>Interview Questions for {jobTitle}</h2>
          </div>
          
          <div className="questions-container">
            {formatQuestions(questions)}
          </div>
        </div>
      )}

      <footer className="footer">
        <p>Get Tailored professional interview questions instantly</p>
      </footer>
    </div>
  );
}

export default InterviewGenerator;