import { Route, Routes } from 'react-router-dom';
import Basic from './pages/Basic';
import Basic2 from './pages/Basic2';
import NewsPage from './pages/NewsPage';

const App = () => {
  return (
    <Routes>
        <Route path="/Basic" element={<Basic />} />
        <Route path="/Basic2" element={<Basic2 />} />
        <Route path="/" element={<NewsPage />} />
        <Route path="/:category" element={<NewsPage />} />
    </Routes>
  );
};

export default App;
