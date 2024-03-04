import axios from 'axios';
import { useState, useEffect } from 'react';

var isInit = false;

const Basic2 = ()=>{
    const [newsJson, setNewsJson] = useState('');
    const [news, setNews] = useState([]);

    const newsList = news.map(item => (
        <div key={item.title}>
            Title : {item.title} <br/>
            Content : {item.description} <br/>
            url : {item.url} <br/>
            <img src={item.urlToImage} alt=""/>
            <br/>
            <br/>
        </div>
    ));

    useEffect(()=>{
        if(isInit === false){
            isInit = true;
            onClickUpdateAsync();
        }
    });

    // 비동기식 - 정상 O
    // async : 비동기식 키워드
    // await : 함수 앞에 붙는 비동기 요청에 대한 처리
    const onClickUpdateAsync = async (e)=>{
        try {
            const response = await axios.get('https://newsapi.org/v2/top-headlines?country=kr&apiKey=0a8c4202385d4ec1bb93b7e277b3c51f');
            console.log(response);
            setNewsJson(JSON.stringify(response.data));
            setNews(response.data.articles);
        } catch (error) {
        }
    }

    return (
        <div>
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

export default Basic2;