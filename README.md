# GnomIoT

Aplicação em Java para a disciplina de Modelagem do Curso de Bacharelado em Ciência da Computação da UFRRJ.

Criado por: Beatriz Cardoso, Gabriel Lacerda, João Mário, Leonardo Iglesias, Marcos Silva, Rafael Aranzate e Willian Caetano.

## Minimundo

O sistema para Casas Inteligentes "GnomIoT" foi desenvolvido para centralizar e facilitar o uso e controle dos dispositivos IoT, não só na seleção de seus estados, como também no controle de acesso, quem poderá alterar quais dispositivos, e na organização segundo as preferências do usuário com maior permissão da residência. Seu principal objetivo é promover conforto e garantir a segurança e integridade dos dispositivos confiados ao Software.

O sistema será acessado por um um software disponibilizado para algumas plataformas (GnomIoT). Para acessá-lo, será necessário ter uma conta. Logo, um usuário novo deverá se cadastrar, informando nome, email e uma senha. Um email será enviado para a validação da conta. Em seguida, o software poderá ser acessado por quaisquer outros dispositivos com o mesmo software. O usuário poderá, diretamente: criar uma residência ou acessar alguma na qual já esteja cadastrado. 

O sistema possibilitará a criação de "residências", que fornecerão a base para cadastrar usuários, cômodos e dispositivos, assim como estabelecer a relação direta ou indiretamente com essas outras instâncias do problema; possuem um nome. As residências serão responsáveis, portanto, em lembrar os cômodos e dispositivos criados e cadastrados, respectivamente, dentro desta; e também lembrar, identificar e filtrar os acessos dos usuários através de um “perfil” criado exclusivamente para a residência. Nesses “perfis” estarão informações de acesso e permissões, assim como o "Cargo" do usuário na Residência, e os cômodos que o usuário terá acesso. Os “perfis” serão criados pela residência sempre que um usuário novo adentrá-la. Para adentrar numa residência, o Administrador ou Dono deverá procurar pelo sistema por um usuário já cadastrado correspondente; em seguida, deverá adicioná-lo diretamente à residência. Ao excluir uma residência, todos os “perfis”, cômodos e dispositivos associados serão apagados também, pois não existem independentemente.

Os "Cargos" são divididos em três tipos:

* Dono: acesso máximo à residência. Só quem cria a residência obterá os status de Dono. Possui exclusivamente o poder de excluir a residência.

* Administrador: acesso parcial ao controle da residência. O cargo de administrador pode ser atribuído a qualquer usuário do sistema através do Dono ou outro Administrador. Possui inúmeros poderes, cujo Dono também possui, como: Criar/Remover cômodos; Cadastrar/Remover dispositivos; Adicionar/Remover usuários; Alterar as permissões de acesso de um usuário comum às residências; por fim, associar dispositivos à residência.

* Usuário Padrão: Acesso restrito à residência. Seria o cargo padrão para um novo usuário que foi aceito numa nova residência. Suas permissões incluem, assim como no caso dos Administradores e Dono: Adentrar os cômodos, mas somente os permitidos; visualizar os dispositivos associados aos cômodos; e alterar o estado dos dispositivos dentro do cômodo.

Os cômodos são outra instância de organização. Eles poderão ser criados por Administradores e Donos, possuindo um nome. Neles encontrar-se-ão os dispositivos associados. Os cômodos poderão ser visitados apenas por usuários com permissão. Os usuários que possuírem acesso ao cômodo poderão interagir com os dispositivos associados a esse; poderão alterar seus estados e ver informações detalhadas, tanto técnicas quanto operacionais.

Os dispositivos serão cadastrados diretamente na residência. Através da identificação e seleção do modelo já pré conhecido do dispositivo pelo sistema, o Administrador ou Dono poderão conectar-se aos dispositivos para incluí-los na residência.

## Diagrama de Casos de Uso

![unnamed](https://user-images.githubusercontent.com/72050839/147513067-ccb772da-c0f3-4e24-b294-ac016ff6d435.png)

## Diagrama de Classes

![Diagrama de Classe](https://user-images.githubusercontent.com/72050839/147511946-d3be5a8b-e01e-4618-9822-e26a9233585c.jpg)

## Visão do Protótipo

![Screenshot from 2021-12-27 19-56-59](https://user-images.githubusercontent.com/72050839/147512669-67f2c792-a7af-429e-adf4-cac3c56e1dbd.png)

![Screenshot from 2021-12-27 19-59-36](https://user-images.githubusercontent.com/72050839/147512691-c7000cab-ae17-459b-9b8d-28163f1c1f41.png)
![Screenshot from 2021-12-27 20-02-12](https://user-images.githubusercontent.com/72050839/147512695-15864045-e136-4c5f-8ebd-992a89015f3b.png)

![Screenshot from 2021-12-27 20-02-23](https://user-images.githubusercontent.com/72050839/147512706-4a3d6161-6b97-4788-9ef6-83a72bb12d06.png)
![Screenshot from 2021-12-27 20-03-39](https://user-images.githubusercontent.com/72050839/147512721-f967b3c5-d500-432b-a07e-dbd1e4c04793.png)

![Screenshot from 2021-12-27 20-08-50](https://user-images.githubusercontent.com/72050839/147512762-b03998ba-b19b-4fc8-80d5-f1c12af6860f.png)
![Screenshot from 2021-12-27 20-05-25](https://user-images.githubusercontent.com/72050839/147512768-ca60ebda-8dad-421d-94a3-476cd2e6f0ef.png)

![Screenshot from 2021-12-27 20-05-42](https://user-images.githubusercontent.com/72050839/147512772-e5f20a16-d36e-4586-9318-f61f277211e6.png)
![Screenshot from 2021-12-27 20-05-53](https://user-images.githubusercontent.com/72050839/147512779-a4cb2234-a8b2-4996-9970-b67baa3acd4b.png)
 
 ### Observação
 Apenas alguns casos de uso foram implementados neste trabalho.
