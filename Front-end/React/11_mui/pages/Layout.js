import { Outlet, useNavigate,Link } from 'react-router-dom';

const Layout = () => {
  const navigate = useNavigate();

  const goBack = () => {
    // 이전 페이지로 이동
    navigate(-1);
  };

  const goArticles = () => {
    // articles 경로로 이동
    navigate('/articles', {
      replace: true,
    });
  };

  return (
    <div>
      <header style={{ background: 'lightgray', padding: 16, fontSize: 24 }}>
        <Link to="/">홈으로</Link>
        <br/>
        <button onClick={goBack}>뒤로가기</button>
      </header>
      <main>
        <Outlet />
      </main>
    </div>
  );
};

export default Layout;
