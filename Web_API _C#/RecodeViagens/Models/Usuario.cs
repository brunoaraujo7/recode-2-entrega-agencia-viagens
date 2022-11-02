using System.ComponentModel.DataAnnotations.Schema;

namespace RecodeViagens.Models
{
    public class Usuario
    {
        public long Id { get; set; }

        [ForeignKey("id_cargo")]
        public Cargo Cargo { get; set; }
        public string Nome { get; set; }
        public string Cpf { get; set; }
        public string Email { get; set; }
        public string Password { get; set; }
    }
}
