function plus(num1, num2) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            var res = num1 + num2

            console.log(num1 + " + " + num2 + " = ")
            resolve(res)
        }, 3000)
    })
}

function minus(num1, num2) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            var res = num1 - num2

            console.log(num1 + " - " + num2 + " = ")
            resolve(res)
        }, 2000)
    })
}

function mult(num1, num2) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            var res = num1 * num2

            console.log(num1 + " * " + num2 + " = ")
            resolve(res)
        }, 1500)
    })
}

function divide(num1, num2) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            var res = num1 / num2

            console.log(num1 + " / " + num2 + " = ")
            resolve(res)
        }, 1000)
    })
}

async function asyncProcess() {
    const res = await Promise.all( // 변수를 하나로 지정했을 때 값은 배열 값으로 나온다.
        [
            plus(100, 200),
            minus(100, 200),
            mult(100, 200),
            divide(100, 200)
        ]
    )

    console.log(res)
}

asyncProcess()

const PromiseParallelTest7 = () => {

    console.log("PromiseParallelTest7 start")

    console.log("PromiseParallelTest7 Fin")


    return (
        <div className="PromiseParallelTest7">
            <p>
                PromiseParallelTest7
            </p>
        </div>
    )
}
export default PromiseParallelTest7