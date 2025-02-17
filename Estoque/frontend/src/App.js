import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { useLocation } from 'react-router-dom';

//pages
import Login from './pages/login';
import Home from './pages/home';
import Navbar from './pages/navbar';

function NavbarContainer() {
  const location = useLocation();
  const caminhosExcluidos = ['/'];

  return !caminhosExcluidos.includes(location.pathname)? <Navbar /> : null;
}

function App() {
  return (
    <Router>
      <NavbarContainer />
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/" element={<Home />} />
        </Routes>
    </Router>
  );
}

export default App;
