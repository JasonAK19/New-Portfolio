import { useEffect, useState } from 'react'
import './App.css'

function App() {
  const [portfolio, setPortfolio] = useState(null)
  const [error, setError] = useState('')

  useEffect(() => {
    const apiBase = import.meta.env.VITE_API_BASE_URL ?? ''

    fetch(`${apiBase}/api/portfolio`)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Unable to load portfolio data')
        }

        return response.json()
      })
      .then((data) => setPortfolio(data))
      .catch((fetchError) => setError(fetchError.message))
  }, [])

  if (error) {
    return <main className="portfolio"><p>{error}</p></main>
  }

  if (!portfolio) {
    return <main className="portfolio"><p>Loading portfolio...</p></main>
  }

  return (
    <main className="portfolio">
      <h1>{portfolio.name}</h1>
      <h2>{portfolio.title}</h2>
      <p>{portfolio.bio}</p>

      <section>
        <h3>Skills</h3>
        <ul>
          {portfolio.skills.map((skill) => (
            <li key={skill}>{skill}</li>
          ))}
        </ul>
      </section>

      <section>
        <h3>Projects</h3>
        <ul>
          {portfolio.projects.map((project) => (
            <li key={project.name}>
              <strong>{project.name}</strong> — {project.description}
            </li>
          ))}
        </ul>
      </section>
    </main>
  )
}

export default App
