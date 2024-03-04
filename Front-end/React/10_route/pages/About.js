import { useSearchParams } from 'react-router-dom';


// useSearchParams : get query(파라메터)를 가져올때 사용하는 기능
// About?detail=true&mode=5
const About = () => {
    const [searchParams, setSearchParams] = useSearchParams();

    // 첫번째 인자
    const detail = searchParams.get('detail');

    // 두번째 인자
    const mode = searchParams.get('mode');

    const onIncreaseMode = ()=>{
        const nextMode = mode === null ? 1 : parseInt(mode) + 1;
        setSearchParams({mode:nextMode, detail})
    }

    return(
        <div>
            <h1>소개 페이지</h1>
            <div>리액트 라우터를 사용해보는 소개 프로젝트 입니다.</div>
            <div>{detail == null || '리액트에서 useSearchParams을 사용한 예제입니다.'}</div>
            <div>detail : {detail}</div>
            <div>mode : {mode}</div>
            <button onClick={onIncreaseMode}>mode + 1</button>
            <br/>
        </div>
    );


};
export default About;
