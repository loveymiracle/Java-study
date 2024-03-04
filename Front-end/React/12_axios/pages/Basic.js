import axios from 'axios';
import { useState } from 'react';
// AJAX 연동을 위한 node의 axios 사용
// 가이드 : https://axios-http.com/kr/docs/intro

// // POST 요청 전송
// https://axios-http.com/kr/docs/api_intro
// 
const Basic = ()=>{
    const [newsJson, setNewsJson] = useState('');
    const [news, setNews] = useState([]);

    const newsList = news.map(item => (
        <div>
            Title : {item.title} <br/>
            Content : {item.description} <br/>
            url : {item.url} <br/>
            <img src={item.urlToImage} alt=""/>
            <br/>
            <br/>
        </div>
    ));

    // 동기식 코드, axios가 제대로 동작하지 않는다. 이유 : axios자체가 Promise 기반이라 비동기로 호출 필요
    // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise
    const onClickUpdate = (e)=>{
        alert('start!');
        // non-blocking 함수로 변환됨
        const response = axios.get('https://newsapi.org/v2/top-headlines?country=kr&apiKey=0a8c4202385d4ec1bb93b7e277b3c51f');
        console.log(response);
        setNewsJson(JSON.stringify(response.data));
        alert('end!');
    }

    // 비동기식 - 정상 O
    // async : 비동기식 키워드
    // await : 함수 앞에 붙는 비동기 요청에 대한 처리
    const onClickUpdateAsync = async (e)=>{
        alert('start!');
        try {
            // blocking 함수로 변환됨 -> 아래 함수가 모두 실행될 때까지 아래 라인으로 실행되지 않는다.
            const response = await axios.get('https://newsapi.org/v2/top-headlines?country=kr&apiKey=0a8c4202385d4ec1bb93b7e277b3c51f');
            console.log(response);
            setNewsJson(JSON.stringify(response.data));
            setNews(response.data.articles);
        } catch (error) {
        }
        alert('end!');
    }

    return (
        <div>
            <button onClick={onClickUpdate}>Update-동기</button>
            <button onClick={onClickUpdateAsync}>Update-비동기</button>
            <div>
                {newsList}
            </div>
            <hr />
            <div>
                {newsJson}
            </div>

        </div>
    );

}

export default Basic;
