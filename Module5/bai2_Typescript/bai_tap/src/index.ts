// import '../scss/styles.scss';
interface ISingleRepo {
    name: string;
}

interface IRepos {
    items: Array<ISingleRepo>;
}

async function fetchRepo(): Promise<Array<ISingleRepo>> {
    let responses: Response | IRepos = await fetch('https://api.github.com/search/repositories?q=typescript');
    responses = await responses.json() as IRepos;
    return responses.items;
}

function createString(text: string) : HTMLLIElement {
    const item = document.createElement('li') as HTMLLIElement;
    item.textContent = text;
    return item;
}

const container = document.querySelector('.app .list');

async function main() {
    const responses = await fetchRepo();
    responses.forEach((item : any) => {
        const li = createString(item.name);
        container.appendChild(li);
    });
}

main();
