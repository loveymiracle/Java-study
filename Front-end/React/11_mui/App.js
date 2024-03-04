import { Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import Layout from './pages/Layout';
import SignInSide from './pages/SignInSide';
import CustomPage from './pages/CustomPage';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route index element={<Home />} />
        <Route path="/SignInSide" element={<SignInSide />} />
        <Route path="/CustomPage" element={<CustomPage />} />
      </Route>
    </Routes>
  );
}

export default App;
