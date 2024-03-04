import { Link } from 'react-router-dom';

const Home = () => {
  return (
    <div>
      <h1>홈</h1>
      <p>가장 먼저 보여지는 페이지입니다.</p>
      <ul>
        <li>
          <Link to="/SignInSide">SignInSide 페이지</Link>
        </li>
        <li>
          <Link to="/CustomPage">CustomPage 페이지</Link>
        </li>
      </ul>
    </div>
  );
};

export default Home;
