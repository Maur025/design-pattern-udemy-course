from rich.console import Console

console = Console()


class Document:
    title: str
    __content: str
    author: str

    def __init__(self, title: str, content: str, author: str):
        self.title = title
        self.__content = content
        self.author = author

    def clone(self) -> Document:
        return Document(self.title, self.__content, self.author)

    def display_info(self):
        console.print(f'''
        Title: {self.title}
        Content: {self.__content}
        Author: {self.author}
        ''')


def main():
    document1 = Document('Cotización', '500 dolares', 'Mauro')

    console.print(document1)
    document1.display_info()

    document2 = document1.clone()
    document2.title = "Nueva cotización"

    console.print(document2)
    document2.display_info()


main()
