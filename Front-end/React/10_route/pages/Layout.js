import { Outlet, useNavigate,Link } from 'react-router-dom';

const Layout = () => {
    const navigate = useNavigate();
    

    const goBack = (e)=>{
        // 이전 페이지 이동하는 코드
        navigate(-1);
    }

    const goArticles = (e)=>{
        // articles 경로로 이동하는 코드
        navigate('/articles', {replace:true,});
    }

    return(
        <div>
            <header style={{ background: 'lightgray', padding: 16, fontSize: 24, height:100 }}>
                {/* Link : 페이지 이동하는 엘리먼트 */}
                <Link to="/">홈으로</Link>
                <br/>
                <button onClick={goBack}>뒤로가기</button>
                <button onClick={goArticles}>게시글 목록</button>
            </header>
            <main>
                {/* Outlet : 외부에서 주입 될 컴포넌트(페이지) */}
                <Outlet/>            
            </main>
            <footer style={{ background: 'lightgray', padding: 16, fontSize: 24, height:100 }}>
                footer 영역입니다.
            </footer>
        </div>
    )
}

export default Layout;