document.getElementById('trigger').addEventListener('click', () => {
    document.getElementById('file').click();
});


//정규 표현식을 사용하여 파일 형식 제한 함수 만들기
//실행파일 막기, 이미지 파일만 체크, 20M 사이즈보다 크면 막기

const regExp = new RegExp("\.(exe|sh|bat|mis|dll|jar)$"); //실행파일 패턴

const regExpImg = new RegExp("\.(jpg|jepg|png|gif|bmp)$"); //이미파일 패턴

const maxSize = 1024 * 1024 * 50; //최대 사이즈 설정
//리턴값은 0과 1로 리턴
function fileValdation(fileName, fileSize) {
    if (regExp.test(fileName)) {
        //실행파일이면...

        return 0;
    } else if (fileSize > maxSize) {
        return 0;
    } else if (!regExpImg.test(fileName)) {
        return 0;
    } else {
        return 1;
    }
}


//첨부 파일에 따라 파일이 등록가능한지 체크 함수

document.addEventListener('change', (e) => {
    console.log(e.target);

    if (e.target.id == 'file') {
        //document.getElementById('regBtn').disabled = false; // 한번 true 변경되면 다시 돌아오게 해준다
        const fileObject = document.getElementById('file').files; // 여러개의 파일을 배열로 가져옴
        console.log(fileObject);

        let div = document.getElementById('fileZone');
        div.innerHTML = '';
        let ul = `<ul>`;
        let isOk = 1;//fileValidation 함수의 리턴여부를 *로 체크
        for (let file of fileObject) {
            let vaildResult = fileValdation(file.name, file.size);
            isOk *= vaildResult; //모든 파일이 누적되어 *
            ul += `<li>`;
            //업로드 가능 여부를 표시
            console.log(vaildResult);
            ul += `${vaildResult ? '<div>업로드가능' : '<div>업로드 불가능'}</div>`;
            ul += `${file.name}`;
            ul += `<span class="badge text-bg-${vaildResult ? "success" : "danger"}">${file.size}Byte</span></li>`;
        }
        ul += `</ul>`//for문을 끝내고
        div.innerHTML = ul;
        if (isOk == 0) {//첨부 불가능한 파일이 있다는 것을 의미
            document.getElementById('regBtn').disabled = true; //버튼 비활성화
        }


    }
})


//ul -> li 여러개 생성
// li <div>업로드 가능//불가능 </div>
// 파일이름
//<span> 파일 사이즈</span>