import copy

from rich.console import Console

console = Console()


class Pokemon:
    def __init__(self, name: str, type_: str, level: int, attacks: list[str]):
        self.name = name
        self.type = type_
        self.level = level
        self.attacks = attacks

    def clone(self) -> Pokemon:
        return copy.deepcopy(self)

    def display_info(self):
        console.print(f'''
        Nombre: {self.name}\nTipo: {self.type}\nNivel: {self.level}\nAtaques: {', '.join(self.attacks)}
        ''')


def main():
    base_pokemon = Pokemon('Charmander', 'Fuego', 1, ['Llamarada', 'Arañazo'])
    clone1 = base_pokemon.clone()
    clone1.name = 'Charmeleon'
    clone1.level = 16
    clone1.attacks.append('Lanzallamas')

    base_pokemon.display_info()
    console.print("")
    clone1.display_info()


main()
