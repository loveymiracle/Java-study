import {useState} from 'react';

// Key 추가하는 방법은 총 2가지로, index로 추가하는법, 고유 id 값(우리가 지정한 id)을 추가하는 방법

// key 추가 방법2 - 고유값으로 설정하고, 추가, 삭제 하는 방법
const IterationSample3 = () => {
    const [names, setNames] = useState(
        [
            {id:1, text:'홍길동'},
            {id:2, text:'최길동'},
            {id:3, text:'박길동'},
            {id:4, text:'홍길동'},
        ]   
    );

    const [nextNumber, setNextNumber] = useState(names[names.length - 1].id + 1); // 5
    const nameList = names.map((item, index) =>(
        <li key={item.id} onDoubleClick={(e)=> onRemove(item.id)}>
            {item.text} &nbsp; <button onClick={(e)=> onRemove(item.id)}>삭제</button>
        </li>
    ));

    // 추가 기능
    const [inputText, setInputText] = useState('');
    const onChange = (e)=>{
        setInputText(e.target.value);
    }
    const onKeyDown = (e)=>{
        if(e.key === 'Enter'){
            onClick(e);
        }
    }
    const onClick = (e)=>{
        const nextNames = [...names,
            {id : nextNumber, text : inputText}
        ];
        // const nextNames = names.concat({
        //     id:nextNumber,
        //     text:inputText,
        // });
        setNextNumber(nextNumber + 1);
        setNames(nextNames);
        setInputText('');
    }

    // 삭제 기능
    const onRemove = (id)=>{
        const nextNames = names.filter((item)=> item.id !== id);
        setNames(nextNames);
    }

    return(
        <div>
            <h2>추가/삭제가 가능한 list 구현하기</h2>
            <input type="text" name="inputText" value={inputText} onChange={onChange} onKeyDown={onKeyDown} />
            <button onClick={onClick}>추가</button>
            <hr/>
            <ul>
                {nameList}
            </ul>
        </div>
    );
}

export default IterationSample3;
