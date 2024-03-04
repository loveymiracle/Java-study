import React from 'react';

// https://ko.legacy.reactjs.org/docs/lists-and-keys.html

// key가 존재하지 않은 경우 에러가 발생함
// UI는 정상 작동하나 동명이인이나 같은 데이터를 삭제할때 기준이 없어서 삭제 어려울수 있음
const IterationSample1 = () => {
    const names = ['홍길동','김길동','최길동','박길동'];
    const nameList = names.map(item => (<li> {item} </li>)); // array를 렌더링 가능한 list로 만드는 과정
    return (
        <div>
            <h2>불완전한 코드버전 - key가 없음</h2>
            <ul>{nameList}</ul>
        </div>
    )
}

export default IterationSample1;
