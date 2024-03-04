import React from 'react';

// Key 추가하는 방법은 총 2가지로, index로 추가하는법, 고유 id 값(우리가 지정한 id)을 추가하는 방법

// key 추가 방법1 - index로 추가하기
const IterationSample2 = () => {
    const names = ['홍길동','김길동','최길동','박길동'];
    const nameList = names.map((value, index) => (<li key={index}> {value} </li>)); // array를 렌더링 가능한 list로 만드는 과정
    return (
        <div>
            <h2>key가 있는 버전, 에러 발생 안함!!</h2>
            <ul>{nameList}</ul>
        </div>
    )
}

export default IterationSample2;
